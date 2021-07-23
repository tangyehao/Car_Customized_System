package cn.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.dao.StoreDaoInf;
import cn.com.db.DBUtil;
import cn.com.dto.StoreStateDto;

public class StoreDaoImp  implements StoreDaoInf {

	@Override
	public List<StoreStateDto> getStoreByDate(Connection conn, String sql, String startDate, String Enddate) {
		List<StoreStateDto> list  = new ArrayList<StoreStateDto>();
		StoreStateDto p= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, startDate);
			pstm.setString(2, Enddate);
			rs = pstm.executeQuery();
			while(rs.next()){
				p = new StoreStateDto();
				p.setStoreNumber(rs.getInt("parts_num"));
				p.setStorePurchasePrice(rs.getDouble("purchase_price"));
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
