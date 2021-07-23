package cn.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.Parts;
import cn.com.dao.PartsInfoDAOInf;
import cn.com.db.DBUtil;
import cn.com.dto.partChangeInfoDto;

public class PartsInfoDAOImpl implements PartsInfoDAOInf {

	@Override
	public List<Parts> getAllPartsInfoDAO(Connection conn, String sql) {
		// TODO Auto-generated method stub
		List<Parts> list = new ArrayList<Parts>();
		Parts pb = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				pb = new Parts();
				pb.setpID(rs.getInt("parts_id"));
				pb.setpName(rs.getString("parts_name"));
				pb.setpColour(rs.getString("parts_color"));
				pb.setpModle(rs.getInt("modle_id"));
				pb.setpNote(rs.getString("parts_note"));
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
	public Boolean addPartsInfoDAO(Connection conn, String sql, Parts pb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pb.getpName());
			pstm.setString(2, pb.getpColour());
			pstm.setInt(3, pb.getpModle());
			pstm.setString(4, pb.getpNote());
			int len = pstm.executeUpdate();
			if(len > 0) {
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
	public Boolean validateByPartsIdDAO(Connection conn, String sql, int pbId) {
		// TODO Auto-generated method stub
		boolean bool = false;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, pbId);
			rs = pstm.executeQuery();
			bool = rs.next();
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
		
		return bool;	
	}

	@Override
	public boolean updatePartsInfoDAO(Connection conn, String sql, Parts pb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,pb.getpName());
			pstm.setString(2,pb.getpColour());
			pstm.setString(3,pb.getpNote());
			pstm.setInt(4,pb.getpID());
			int len = pstm.executeUpdate();
			if(len > 0) {
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
	public boolean delPartsInfoByPartsIdDAO(Connection conn, String sql, int partsId) {
		// TODO Auto-generated method stub
		boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,partsId);
			int len = pstm.executeUpdate();
			if(len > 0) {
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
	public List<Parts> getPartsInfoByPartsNameDAO(Connection conn, String sql, String PartsName) {
		// TODO Auto-generated method stub
		List<Parts> list = new ArrayList<Parts>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%"+PartsName+"%");
			rs = pstm.executeQuery();
			Parts pb = null;
			while(rs.next()) {
				pb = new Parts();
				pb.setpID(rs.getInt("parts_id"));
				pb.setpModle(rs.getInt("modle_id"));
				pb.setpName(rs.getString("parts_name"));
				pb.setpColour(rs.getString("parts_color"));
				pb.setpNote(rs.getString("parts_note"));
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
	public List<partChangeInfoDto> getPartsChangeAll(Connection conn, String sql) {
		// TODO Auto-generated method stub
		List<partChangeInfoDto> list = new ArrayList<partChangeInfoDto>();
		partChangeInfoDto pci = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				pci = new partChangeInfoDto();
				pci.setParts_id(rs.getInt("parts_id"));
				pci.setParts_name(rs.getString("parts_name"));
				pci.setParts_num(rs.getInt("parts_num"));
				pci.setUser_name(rs.getString("user_name"));
				pci.setUserphone(rs.getString("user_phone"));
				pci.setFlog(rs.getString("flog_name"));
				list.add(pci);
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
	public List<partChangeInfoDto> getPartsChangeByPartsName(Connection conn, String sql, String parts_name1) {
		// TODO Auto-generated method stub
		List<partChangeInfoDto> list = new ArrayList<partChangeInfoDto>();
		partChangeInfoDto pci= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,"%"+parts_name1+"%");
			rs = pstm.executeQuery();
			while (rs.next()) {
				pci = new partChangeInfoDto();
				pci.setParts_id(rs.getInt("parts_id"));
				pci.setParts_name(rs.getString("parts_name"));
				pci.setParts_num(rs.getInt("parts_num"));
				pci.setUser_name(rs.getString("user_name"));
				pci.setUserphone(rs.getString("user_phone"));
				pci.setFlog(rs.getString("flog_name"));
				
				list.add(pci);
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
