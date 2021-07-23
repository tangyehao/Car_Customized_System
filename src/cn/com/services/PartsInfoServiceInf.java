package cn.com.services;

import java.util.List;

import cn.com.beans.Parts;
import cn.com.dto.partChangeInfoDto;

public interface PartsInfoServiceInf {
	List<Parts> getAllPartsInfoService();
	Boolean addPartsInfoService(Parts pb);
	Boolean validateByPartsIdService(int pbId);
	Boolean upDatePartsInfoService(Parts pb);
	Boolean delPartsInfoByPartsIdService(int pbId);
	
	List<Parts> getPartsInfoByPartsNameService(String PartsName);
	List<partChangeInfoDto> getPartsChangeInfoByPartsName(String parts_name1);
	
}
