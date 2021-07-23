package cn.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.com.dao.BillBaseDaoInf;
import cn.com.db.DBUtil;
import cn.com.dto.BillViewDto;
import cn.com.dto.PartDto;

public class BillBaseDaoImp implements BillBaseDaoInf {

	@Override
	public List<BillViewDto> getBillBaseByBillIdDao(Connection conn, String sql) {
		
		List<BillViewDto> list  = new ArrayList<BillViewDto>();
		BillViewDto b = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){

				b = new BillViewDto();
				b.setbIdDto(rs.getInt("bill_id"));
				b.setClientorfactoryDto(rs.getString("firm_name"));
				b.setPayableDto(rs.getDouble("bill_payable"));
				b.setPaidDto(rs.getDouble("bill_paid"));
				b.setInArrearDto(rs.getDouble("bill_in_arrear"));
				b.setUserDto(rs.getString("user_name"));
				b.setFlogNameDto(rs.getString("flog_name"));
				b.setDateDto(rs.getDate("bill_date"));
				list.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBUtil.freeResultSet(rs);
//				DBUtil.freeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}

	@Override
	public List<BillViewDto> getBillBaseByBillIdDao(Connection conn, String sql, int id) {
		List<BillViewDto> list  = new ArrayList<BillViewDto>();
		BillViewDto b = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,id);
			rs = pstm.executeQuery();
			while(rs.next()){

				
				b = new BillViewDto();
				b.setbIdDto(rs.getInt("bill_id"));
				b.setClientorfactoryDto(rs.getString("firm_name"));
				
				b.setPayableDto(rs.getDouble("bill_payable"));
				b.setPaidDto(rs.getDouble("bill_paid"));
				b.setInArrearDto(rs.getDouble("bill_in_arrear"));
				b.setUserDto(rs.getString("user_name"));
				b.setFlogNameDto(rs.getString("flog_name"));
				b.setDateDto(rs.getDate("bill_date"));
				
								
				list.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBUtil.freeResultSet(rs);
//				DBUtil.freeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}

	@Override
	public List<PartDto> getPartDao(Connection conn, String sql ,int value) {
		List<PartDto> list  = new ArrayList<PartDto>();
		PartDto p = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,value);
			rs = pstm.executeQuery();
			while(rs.next()){

				p = new PartDto();
				p.setPartIdDto(rs.getInt("parts_id"));
				p.setPartNameDto(rs.getString("parts_name"));
				p.setPartColorDto(rs.getString("parts_color"));
				p.setPartNumberDto(rs.getInt("parts_num"));
				p.setPartPriceDto(rs.getDouble("purchase_price"));
				p.setPartTotalPriceDto(rs.getInt("parts_num")*rs.getDouble("purchase_price"));
								
				list.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBUtil.freeResultSet(rs);
//				DBUtil.freeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}

}
	


