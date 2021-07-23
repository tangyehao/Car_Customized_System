package cn.com.services;

import java.util.List;

import cn.com.beans.Bill;
import cn.com.dto.BillViewDto;
import cn.com.dto.PartDto;

public interface  BillManageServiceInf {
//	List<Bill> billExport(); 
//	boolean billImport(List<Bill> list);
//	boolean billUpdate(Bill b);
//	boolean billAdd(Bill b);
//	boolean billDelete(Bill b);
//	List<Bill> businessAnalysis(String beginTime,String endTime); //报账分析，按日期分析
//	List<Bill> billExportByID(int bID); //通过单号查询
//	List<Bill> billExportByFlog(int bFlog); //通过标签查询
	

	List<BillViewDto> getbillByIDService();//通过单号查询
	List<BillViewDto> getbillByIDService(int id);//通过单号查询
	List<PartDto> getPartSerice(int value);
	
}
