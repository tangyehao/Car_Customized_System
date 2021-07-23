package cn.com.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.Parts;
import cn.com.dao.PartsInfoDAOInf;
import cn.com.dao.impl.PartsInfoDAOImpl;
import cn.com.db.DBUtil;
import cn.com.dto.partChangeInfoDto;
import cn.com.services.PartsInfoServiceInf;


public class PartsInfoServiceImpl implements PartsInfoServiceInf {
	
	private PartsInfoDAOInf dao;
	
	public PartsInfoServiceImpl() {
		dao = new PartsInfoDAOImpl();
	}

	@Override
	public List<Parts> getAllPartsInfoService() {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<Parts> list = null;
		String sql = "select * from tb_parts";
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			list = dao.getAllPartsInfoDAO(conn, sql);
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
		//System.out.println(list.size());
		return list;
	}

	@Override
	public Boolean addPartsInfoService(Parts pb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql2 = "insert into tb_parts values(seq_Parts_id.Nextval,?,?,?,?)";
			bool = dao.addPartsInfoDAO(conn, sql2, pb);
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
	public Boolean validateByPartsIdService(int pbId) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select * from tb_parts where parts_id =?";
			bool = dao.validateByPartsIdDAO(conn, sql, pbId);
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
	public Boolean upDatePartsInfoService(Parts pb) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "update tb_parts set parts_name =?,parts_color =?,parts_note =? where modle_id =?";
			bool = dao.updatePartsInfoDAO(conn, sql, pb);
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
	public Boolean delPartsInfoByPartsIdService(int pbId) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "delete from tb_parts where parts_id =?";
			bool = dao.delPartsInfoByPartsIdDAO(conn, sql, pbId);
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
	public List<Parts> getPartsInfoByPartsNameService(String PartsName) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<Parts> list = null;
		String sql = "select * from tb_parts where parts_name like ?";
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			list = dao.getPartsInfoByPartsNameDAO(conn, sql, PartsName);
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
	public List<partChangeInfoDto> getPartsChangeInfoAllService() {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<partChangeInfoDto> list = null;
		String sql = "select  parts_id,parts_num,parts_name,user_name,user_phone,flog_name from ((tb_ssbb_flog left join tb_ssbb on tb_ssbb_flog.flog_id = tb_ssbb.flog_id)left join tb_parts on tb_ssbb.parts_id = tb_parts.parts_id) left join tb_user on tb_ssbb.user_id = tb_user.user_id";
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			list = dao.getPartsChangeAll(conn, sql);
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
	public List<partChangeInfoDto> getPartsChangeInfoByPartsName(String parts_name1) {
		// TODO Auto-generated method stub
		List<partChangeInfoDto> list = new ArrayList<partChangeInfoDto>();
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select  parts_id,parts_num,parts_name,user_name,user_phone,flog_name from ((tb_ssbb_flog left join tb_ssbb on tb_ssbb_flog.flog_id = tb_ssbb.flog_id)left join tb_parts on tb_ssbb.parts_id = tb_parts.parts_id) left join tb_user on tb_ssbb.user_id = tb_user.user_id where parts_name like ?";
			list = dao.getPartsChangeByPartsName(conn, sql, parts_name1);
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
