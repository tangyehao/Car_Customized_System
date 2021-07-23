package cn.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.Firm;
import cn.com.dao.FirmInfoManageDaoInf;
import cn.com.db.DBUtil;

public class FirmInfoManageDaoImpl implements FirmInfoManageDaoInf{
	public List<Firm> firmExport(Connection con,String sql){
		List<Firm> list = new ArrayList<Firm>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = con.prepareStatement(sql);
			rs =  pstm.executeQuery();
			while(rs.next()) {
				Firm f = new Firm();
				f.setfID(rs.getInt("firm_id"));
				f.setfName(rs.getString("firm_name"));
				f.setfAddress(rs.getString("firm_address"));
				f.setfPhone(rs.getString("firm_phone"));
				f.setfNote(rs.getString("firm_note"));
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
	public  boolean firmUpdate(Connection con,String sql,Firm f){
		boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1,f.getfName());
			pstm.setString(2,f.getfAddress());
			pstm.setString(3,f.getfPhone());
			pstm.setString(4,f.getfNote());
			pstm.setInt(5,f.getfID());
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
	public  boolean firmAdd(Connection con,String sql,Firm f){
		boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1,f.getfName());
			pstm.setString(2,f.getfAddress());
			pstm.setString(3,f.getfPhone());
			pstm.setString(4,f.getfNote());
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
	@Override
	public boolean firmDelete(Connection con, String sql, Firm f) {
		// TODO Auto-generated method stub
		boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1,f.getfName());

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
	public List<Firm> firmExportByName(Connection con, String sql,String fname) {
		// TODO Auto-generated method stub
		List<Firm> list = new ArrayList<Firm>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1,"%"+fname+"%");
			rs =  pstm.executeQuery();
			while(rs.next()) {
				Firm f = new Firm();
				f.setfName(rs.getString("firm_name"));
				f.setfAddress(rs.getString("firm_address"));
				f.setfPhone(rs.getString("firm_phone"));
				f.setfNote(rs.getString("firm_note"));
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
}
