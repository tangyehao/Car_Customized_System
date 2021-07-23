package cn.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import cn.com.dao.BuyDaoInf;
import cn.com.db.DBUtil;
import cn.com.dto.PurchaseDto;
public class BuyDaoImp  implements BuyDaoInf {

	

	
	public List<PurchaseDto> getBuyByDateDao(Connection conn, String sql, String startDate, String Enddate) {
		
		List<PurchaseDto> list  = new ArrayList<PurchaseDto>();
		PurchaseDto p= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, startDate);
			pstm.setString(2, Enddate);
			rs = pstm.executeQuery();
			while(rs.next()){
				p = new PurchaseDto();
				p.setPurchaseProductNumberDto(rs.getInt("parts_NUM"));
				p.setPurchaseFlogDto(rs.getInt("FLOG_ID"));
				p.setPurchasePurchase_PriceDto(rs.getDouble("purchase_price"));
				p.setPurchaseSell_PriceDto(rs.getDouble("selling_price"));
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
