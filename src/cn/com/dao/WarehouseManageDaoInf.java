package cn.com.dao;

import java.sql.Connection;
import java.util.List;

import cn.com.beans.Warehouse;

import cn.com.dto.WarePartsInfoDto;
import cn.com.dto.WareUserDto;
import cn.com.dto.partChangeInfoDto;

public interface WarehouseManageDaoInf {
	List<WarehouseManageDaoInf> WarehouseExport(Connection con,String sql);
	boolean WarehouseAdd(Connection con,String sql,Warehouse w);
	boolean WarehouseUpdate(Connection con,String sql,Warehouse w);

	List<WarePartsInfoDto> getAllWareInfoDAO(Connection conn, String sql);//����ѯ�����ݿ�
	List<WarePartsInfoDto> getAllWareStatInfoDAO(Connection conn, String sql);//���ɱ�ͳ��
	List<WarePartsInfoDto> getPartByParts_nameDao(Connection conn,String sql,String parts_name);
	List<WarePartsInfoDto> getPartStatByParts_nameDao(Connection conn,String sql,String parts_name);

	List<WareUserDto> getWareHouseInfoDao(Connection conn,String sql);//�ֿ����������ݿ�
	boolean validateByWarehouseId(Connection conn,String sql,int warehosue_id);//��֤�����Ƿ�Ψһ
	boolean addWareUser(Connection conn, String sql, WareUserDto wud);//��������

	boolean updateWareUser(Connection conn,String sql,WareUserDto wud); //�޸�����
	boolean delWareUserInfoDAO(Connection conn, String sql, int wareid);


	List<partChangeInfoDto> getPartsChangeAll(Connection conn,String sql);//�ı������ݿ�
	List<partChangeInfoDto> getPartsChangeByPartsName(Connection conn,String sql,String parts_name);
}
