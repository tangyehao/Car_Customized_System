package cn.com.dao;

import java.sql.Connection;
import java.util.List;

import cn.com.beans.Bill;
import cn.com.dto.BillViewDto;
import cn.com.dto.PartDto;



public interface BillBaseDaoInf {
	List<BillViewDto> getBillBaseByBillIdDao(Connection conn, String sql);
	List<BillViewDto> getBillBaseByBillIdDao(Connection conn, String sql,int id);
	List<PartDto> getPartDao(Connection conn, String sql,int value);
}
