package cn.com.dao;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import cn.com.beans.Bill;
import cn.com.beans.Inventory;
import cn.com.dto.PurchaseDto;

public interface BuyDaoInf {
	List<PurchaseDto> getBuyByDateDao(Connection conn, String sql,String startDate,String Enddate);
}
