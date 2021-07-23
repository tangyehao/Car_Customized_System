package cn.com.dao;

import java.sql.Connection;
import java.util.List;

import cn.com.beans.Modle;

public interface ModleInfoDaoInf {
	List<Modle> modleExport(Connection con,String sql);
	List<Modle> modleExport(Connection con,String sql,int mId);
	boolean modleUpdate(Connection con,String sql,Modle m);
	boolean modleAdd(Connection con,String sql,Modle m);
	boolean modleDelete(Connection con,String sql,Modle m);
}
