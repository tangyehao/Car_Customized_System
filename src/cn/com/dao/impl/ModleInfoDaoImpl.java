package cn.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.Modle;
import cn.com.dao.ModleInfoDaoInf;
import cn.com.db.DBUtil;

public class ModleInfoDaoImpl implements ModleInfoDaoInf{

	@Override
	public List<Modle> modleExport(Connection con, String sql) {
		// TODO Auto-generated method stub
		List<Modle> list = new ArrayList<Modle>();
		Modle pb = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				pb = new Modle();
				pb.setmID(rs.getInt("modle_id"));
				pb.setmName(rs.getString("modle_name"));
				pb.setmType(rs.getString("modle_type"));
				pb.setmPurchasePrice(rs.getInt("purchase_price"));
				pb.setmSellPrice(rs.getInt("selling_price"));
				pb.setmCapacity(rs.getInt("modle_capacity"));
				list.add(pb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	@Override
	public boolean modleUpdate(Connection con, String sql, Modle m) {
		// TODO Auto-generated method stub
		boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1,m.getmName());
			pstm.setString(2,m.getmType());
			pstm.setInt(3,m.getmPurchasePrice());
			pstm.setInt(4,m.getmSellPrice());
			pstm.setInt(5,m.getmCapacity());
			pstm.setInt(5,m.getmID());
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
	public boolean modleAdd(Connection con, String sql, Modle m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modleDelete(Connection con, String sql, Modle m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Modle> modleExport(Connection con, String sql, int mId) {
		// TODO Auto-generated method stub
		List<Modle> list = new ArrayList<Modle>();
		Modle pb = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1,mId);
			rs = pstm.executeQuery();
			while(rs.next()) {
				pb = new Modle();
				pb.setmID(rs.getInt("modle_id"));
				pb.setmName(rs.getString("modle_name"));
				pb.setmType(rs.getString("modle_type"));
				pb.setmPurchasePrice(rs.getInt("purchase_price"));
				pb.setmSellPrice(rs.getInt("selling_price"));
				pb.setmCapacity(rs.getInt("modle_capacity"));
				list.add(pb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
