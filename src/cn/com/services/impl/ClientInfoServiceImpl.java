package cn.com.services.impl;

import cn.com.beans.Client;
import cn.com.dao.ClientInfoDAOInf;
import cn.com.dao.impl.ClientInfoDAOImpl;
import cn.com.db.DBUtil;
import cn.com.services.ClientInfoServiceInf;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ClientInfoServiceImpl implements ClientInfoServiceInf {
	private ClientInfoDAOInf dao;
	
	public ClientInfoServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new ClientInfoDAOImpl();
	}
	
	@Override
	public List<Client> getAllClientInfoService() {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<Client> list = null;
		String sql = "select * from tb_client";
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			list = dao.getAllClientInfoDAO(conn, sql);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				DBUtil.freeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public Boolean updateClientInfoService(Client cb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "update tb_client set client_name =?,client_address =?,client_phone =?,client_note =? where client_id =?";
			bool = dao.updateClientInfoDAO(conn, sql, cb);
			if(bool) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				DBUtil.freeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}

	@Override
	public Boolean delClientInfoService(int clientId) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "delete from tb_client where client_id =?";
			bool = dao.delClientInfoDAO(conn, sql, clientId);
			if(bool) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if(conn != null) {
				try {
					DBUtil.freeConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return bool;
	}

	@Override
	public Boolean validateByClientIdService(int clientId) {
		// TODO Auto-generated method stub
		Boolean bool = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select * from tb_client where client_id =?";
			bool = dao.validateByClientIdDAO(conn, sql, clientId);
			if(bool) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}

	@Override
	public Boolean addClientInfoService(Client cb) {
		// TODO Auto-generated method stub
		Boolean bool = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql1 = "select * from tb_client where client_id =?";
			bool = dao.validateByClientIdDAO(conn, sql1, cb.getcID());
			if(bool) {
				conn.rollback();
				return bool;
			}
			if(cb.getcID() == 0) {
				return bool;
			}
			if(cb == null) {
				return bool;
			}
			String sql2 = "insert into tb_client values(?,?,?,?,?)";
			bool = dao.addClientInfoDAO(conn, sql2, cb);
			if(bool) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn = DBUtil.getConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}

	@Override
	public List<Client> getClientInfoByClientNameService(String clientName) {
		Connection conn = null;
		List<Client> list = null;
		String sql = "select * from tb_client where client_name like ?";
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			list = dao.getClientInfoByClientNameDAO(conn, sql, clientName);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				DBUtil.freeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

}
