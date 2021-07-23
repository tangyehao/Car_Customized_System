package cn.com.dao;

import java.sql.Connection;
import java.util.List;

import cn.com.beans.Bill;

public interface BillInfoManageDaoInf {
	//账单信息管理
	List<Bill> billExport(Connection con,String sql);
	boolean billImport(Connection con,String sql,List<Bill> list);
	boolean billUpdate(Connection con,String sql,Bill b);
	boolean billAdd(Connection con,String sql,Bill b);
	boolean billDelete(Connection con,String sql,Bill b);
}
