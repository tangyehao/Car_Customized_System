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
//	List<Bill> businessAnalysis(String beginTime,String endTime); //���˷����������ڷ���
//	List<Bill> billExportByID(int bID); //ͨ�����Ų�ѯ
//	List<Bill> billExportByFlog(int bFlog); //ͨ����ǩ��ѯ
	

	List<BillViewDto> getbillByIDService();//ͨ�����Ų�ѯ
	List<BillViewDto> getbillByIDService(int id);//ͨ�����Ų�ѯ
	List<PartDto> getPartSerice(int value);
	
}
