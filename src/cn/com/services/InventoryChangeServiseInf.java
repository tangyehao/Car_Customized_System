package cn.com.services;

import cn.com.beans.Warehouse;

public interface InventoryChangeServiseInf {
	//��������
	boolean InventoryExport(); //�������
	boolean InventoryImport(); //������
	boolean InventoryAllocation(Warehouse original,Warehouse goal); //������
}
