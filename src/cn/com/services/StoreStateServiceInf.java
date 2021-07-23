package cn.com.services;

import java.util.List;

import cn.com.dto.StoreStateDto;

public interface  StoreStateServiceInf {
	List<StoreStateDto>getStoreStateByDateService(String  startDate, String endDate);
}
