package cn.com.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.Firm;
import cn.com.dao.impl.FirmInfoManageDaoImpl;
import cn.com.db.DBUtil;
import cn.com.services.FirmManageServiseInf;



public class FirmManageServiseImpl  implements FirmManageServiseInf{
	private FirmInfoManageDaoImpl dao;
	
	public FirmManageServiseImpl() {
		dao = new FirmInfoManageDaoImpl();
	}
	
	public List<Firm> firmExport(){
		Connection con = null;
		List<Firm> list = null;
		boolean bool = false;
		try {
			con = DBUtil.getConn();
			con.setAutoCommit(false);
			list = new ArrayList<Firm>();
			String sql = "select * from tb_firm";
			list = dao.firmExport(con, sql);
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
	public List<Firm> firmExportByName(String fName){
		List<Firm> list = new ArrayList<Firm>();
		boolean bool = false;
		Connection con = null;
		String sql = "select * from tb_firm where firm_name like ?";
		try {
			con = DBUtil.getConn();
			con.setAutoCommit(false);
			list = dao.firmExportByName(con, sql,fName);
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
	public List<Firm> firmExportByPhone(String fPhone){
		List<Firm> list = new ArrayList<Firm>();
		
		
		
		return list;
	}
	public  boolean firmUpdate(Firm f){
		boolean bool = false;
		Connection con = null;
		String sql = "update tb_firm set firm_name = ?,firm_address = ?,firm_phone = ?,firm_note = ? where firm_id = ?";
		try {
			con = DBUtil.getConn();
			con.setAutoCommit(false);
			bool = dao.firmUpdate(con, sql, f);
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
		return bool;
	}
	public  boolean firmAdd(Firm f){
		boolean bool = false;
		Connection con = null;
		String sql = "insert into tb_firm values(seq_Firm_riem_id.nextval,?,?,?,?)";
		try {
			con = DBUtil.getConn();
			con.setAutoCommit(false);
			bool = dao.firmAdd(con, sql, f);
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
		return bool;
	}

	@Override
	public boolean firmDelete(Firm f) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection con = null;
		String sql = "delete from tb_firm where firm_name = ?";
		try {
			con = DBUtil.getConn();
			con.setAutoCommit(false);
			bool = dao.firmDelete(con, sql, f);
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
		return bool;
	}
}
