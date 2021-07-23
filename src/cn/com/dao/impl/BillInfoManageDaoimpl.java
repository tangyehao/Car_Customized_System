package cn.com.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.Bill;
import cn.com.beans.Bill;
import cn.com.db.DBUtil;
import cn.com.views.stockview.StockView;

public class BillInfoManageDaoimpl{
	//账单信息管理
	public List<Bill> billExport(Connection con,String sql){
		List<Bill> list = new ArrayList<Bill>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = con.prepareStatement(sql);
			rs =  pstm.executeQuery();
			while(rs.next()) {
				Bill f = new Bill();
				f.setbID(rs.getInt("bill_id"));
				f.setAmountPayable(rs.getInt("bill_payable"));
				f.setAmountPaid(rs.getInt("bill_paid"));
				f.setAmountInArrear(rs.getInt("bill_in_arrear"));
				f.setbFlog(rs.getInt("flog_id"));
				f.setbDate(rs.getDate("bill_date"));
				list.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				DBUtil.freeConnection(con);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeResultSet(rs);
				DBUtil.freeStatement(pstm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public boolean billImport(Connection con,String sql,List<Bill> list){
		boolean bool = false;
		return bool;
	}
	public boolean billUpdate(Connection con,String sql,Bill b){
		boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1,b.getAmountPayable());
			pstm.setInt(2,b.getAmountPaid());
			pstm.setInt(3,b.getAmountInArrear());
			pstm.setInt(4,b.getbFlog());
			pstm.setDate(5,(Date) b.getbDate());
			int len = pstm.executeUpdate();
			if(len >0) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeStatement(pstm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}
	public boolean billAdd(Connection con,String sql,Bill b){
		boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1,StockView.billID);
			pstm.setInt(2,b.getAmountPayable());
			pstm.setInt(3,b.getAmountPaid());
			pstm.setInt(4,b.getAmountInArrear());
			pstm.setInt(5,b.getbFlog());
			pstm.setDate(6,(Date)b.getbDate());
			int len = pstm.executeUpdate();
			if(len >0) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeStatement(pstm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}
	public boolean billDelete(Connection con,String sql,Bill b){
		boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1,b.getbID());

			int len = pstm.executeUpdate();
			if(len >0) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeStatement(pstm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}
}
