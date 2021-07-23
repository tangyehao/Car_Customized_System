package cn.com.services;

import java.util.Date;
import java.util.List;

import cn.com.beans.Bill;
import cn.com.beans.Inventory;
import cn.com.dto.PurchaseDto;

public interface BuyManagerServiceInf {
	List<PurchaseDto> getBuyMangerByDateService(String  startDate,String endDate);

	

	 
}
