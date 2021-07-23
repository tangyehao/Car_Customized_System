package cn.com.services;

import cn.com.beans.Warehouse;

public interface InventoryChangeServiseInf {
	//出入库管理
	boolean InventoryExport(); //出库操作
	boolean InventoryImport(); //入库操作
	boolean InventoryAllocation(Warehouse original,Warehouse goal); //库存调拨
}
