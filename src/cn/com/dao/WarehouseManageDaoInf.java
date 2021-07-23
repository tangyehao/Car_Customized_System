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

	List<WarePartsInfoDto> getAllWareInfoDAO(Connection conn, String sql);//库存查询连数据库
	List<WarePartsInfoDto> getAllWareStatInfoDAO(Connection conn, String sql);//库存成本统计
	List<WarePartsInfoDto> getPartByParts_nameDao(Connection conn,String sql,String parts_name);
	List<WarePartsInfoDto> getPartStatByParts_nameDao(Connection conn,String sql,String parts_name);

	List<WareUserDto> getWareHouseInfoDao(Connection conn,String sql);//仓库设置连数据库
	boolean validateByWarehouseId(Connection conn,String sql,int warehosue_id);//验证主键是否唯一
	boolean addWareUser(Connection conn, String sql, WareUserDto wud);//增加数据

	boolean updateWareUser(Connection conn,String sql,WareUserDto wud); //修改数据
	boolean delWareUserInfoDAO(Connection conn, String sql, int wareid);


	List<partChangeInfoDto> getPartsChangeAll(Connection conn,String sql);//四表连数据库
	List<partChangeInfoDto> getPartsChangeByPartsName(Connection conn,String sql,String parts_name);
}
