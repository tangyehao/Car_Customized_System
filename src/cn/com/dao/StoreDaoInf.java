package cn.com.dao;

import java.sql.Connection;
import java.util.List;

import cn.com.dto.PurchaseDto;
import cn.com.dto.StoreStateDto;

public interface  StoreDaoInf {
	
	List<StoreStateDto> getStoreByDate(Connection conn, String sql,String startDate,String Enddate);
}
