package cn.com.services;

import java.util.List;

import cn.com.beans.Warehouse;
import cn.com.dto.WarePartsInfoDto;
import cn.com.dto.WareUserDto;
import cn.com.dto.partChangeInfoDto;

public interface WarehouseInfoServiceInf {
	List<Warehouse> warehouseExport();
	boolean warehouseAdd(Warehouse w);
	boolean warehouseUpdate(Warehouse w);
	List<WarePartsInfoDto> getAllWarePartInfoService();
	List<WarePartsInfoDto> getAllWareStatPartInfoService();
	List<WarePartsInfoDto> getWarePartInfoByParts_nameServiceImpl(String parts_name);
	List<WarePartsInfoDto> getWareStatInfoByParts_nameServiceImpl(String parts_name);

	List<WareUserDto> getWareHouseAllInfo();
	boolean validateByWarehouseIdService(int warehouse_id);
	boolean addWareService(WareUserDto wud);
	boolean updateWareUserService(WareUserDto wud);
	boolean delClientInfoService(int wareid);
	
	List<partChangeInfoDto> getPartsChangeInfoAllService();
	List<partChangeInfoDto> getPartsChangeInfoByPartsName(String parts_name);
}
