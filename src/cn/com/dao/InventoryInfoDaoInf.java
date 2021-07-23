package cn.com.dao;

import java.sql.Connection;
import java.util.List;

import cn.com.beans.Inventory;

public interface InventoryInfoDaoInf {
	List<Inventory> inventoryExport(Connection con,String sql);
	boolean inventoryUpdate(Connection con,String sql,Inventory i);
	boolean inventoryAdd(Connection con,String sql,Inventory i);
}
