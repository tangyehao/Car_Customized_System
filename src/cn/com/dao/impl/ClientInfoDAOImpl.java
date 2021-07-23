package cn.com.dao.impl;

import cn.com.beans.Client;
import cn.com.dao.ClientInfoDAOInf;
import cn.com.db.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClientInfoDAOImpl implements ClientInfoDAOInf {

	@Override
	public List<Client> getAllClientInfoDAO(Connection conn, String sql) {
		// TODO Auto-generated method stub
		List<Client> list = new ArrayList<Client>();
		Client cb = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				cb = new Client();
				cb.setcID(rs.getInt("client_id"));
				cb.setcName(rs.getString("client_name"));
				cb.setcAddress(rs.getString("client_address"));
				cb.setcPhone(rs.getString("client_phone"));
				cb.setcNote(rs.getString("client_note"));
				
				list.add(cb);
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
	public boolean updateClientInfoDAO(Connection conn, String sql, Client cb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,cb.getcName());
			pstm.setString(2,cb.getcAddress());
			pstm.setString(3,cb.getcPhone());
			pstm.setString(4,cb.getcNote());
			pstm.setInt(5,cb.getcID());
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
	public boolean delClientInfoDAO(Connection conn, String sql, int clientId) {
		// TODO Auto-generated method stub
		Boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, clientId);
			int len = pstm.executeUpdate();
			if(len > 0) {
				bool = true;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstm != null) {
				try {
					DBUtil.freeStatement(pstm);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return bool;
	}

	@Override
	public boolean validateByClientIdDAO(Connection conn, String sql, int clientId) {
		// TODO Auto-generated method stub
		Boolean bool = false;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, clientId);
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
	public boolean addClientInfoDAO(Connection conn, String sql, Client cb) {
		// TODO Auto-generated method stub
		Boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cb.getcID());
			pstm.setString(2, cb.getcName());
			pstm.setString(3, cb.getcPhone());
			pstm.setString(4, cb.getcAddress());
			pstm.setString(5, cb.getcNote());
			
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
	public List<Client> getClientInfoByClientNameDAO(Connection conn, String sql, String clientName) {
		// TODO Auto-generated method stub
		List<Client> list = new ArrayList<Client>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%"+clientName+"%");
			rs = pstm.executeQuery();
			Client cb = null;
			while(rs.next()) {
				cb = new Client();
				cb.setcID(rs.getInt("client_id"));
				cb.setcName(rs.getString("client_name"));
				cb.setcAddress(rs.getString("client_address"));
				cb.setcPhone(rs.getString("client_phone"));
				cb.setcNote(rs.getString("client_note"));
				list.add(cb);
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
