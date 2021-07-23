package cn.com.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.Modle;
import cn.com.dao.impl.ModleInfoDaoImpl;
import cn.com.db.DBUtil;

public class ModleInfoServiceImpl {
	private ModleInfoDaoImpl dao;
	public ModleInfoServiceImpl() {
		dao = new ModleInfoDaoImpl();
	}
	
	public List<Modle> modleExport(){
		Connection con = null;
		List<Modle> list = null;
		boolean bool = false;
		try {
			con = DBUtil.getConn();
			con.setAutoCommit(false);
			list = new ArrayList<Modle>();
			String sql = "select * from tb_modle";
			list = dao.modleExport(con, sql);
			bool = true;
			if(bool) {
				con.commit();
			} else {
				con.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Modle> modleExportById(int mId){
		Connection con = null;
		List<Modle> list = null;
		boolean bool = false;
		try {
			con = DBUtil.getConn();
			con.setAutoCommit(false);
			list = new ArrayList<Modle>();
			String sql = "select * from tb_modle where modle_id = ?";
			list = dao.modleExport(con, sql,mId);
			bool = true;
			if(bool) {
				con.commit();
			} else {
				con.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
