package cn.com.dao;

import java.sql.Connection;
import java.util.List;

import cn.com.beans.Firm;

public interface FirmInfoManageDaoInf {
	List<Firm> firmExport(Connection con,String sql);
	boolean firmUpdate(Connection con,String sql,Firm f);
	boolean firmAdd(Connection con,String sql,Firm f);
	boolean firmDelete(Connection con,String sql,Firm f);
}
