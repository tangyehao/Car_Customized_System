package cn.com.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import cn.com.dao.BuyDaoInf;
import cn.com.dao.impl.BuyDaoImp;
import cn.com.db.DBUtil;
import cn.com.dto.PurchaseDto;
import cn.com.services.BuyManagerServiceInf;

public class BuyManagerServiceImp implements BuyManagerServiceInf {
	private BuyDaoInf dao;
	
	public BuyManagerServiceImp(){
		dao = new BuyDaoImp();
	}
	
	
	@Override
	public List<PurchaseDto> getBuyMangerByDateService(String startDate,String endDate) {
		List<PurchaseDto> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select tb_SSBB.parts_num, tb_bill .flog_id,purchase_price ,selling_price from ((tb_bill left join tb_SSBB on tb_bill.bill_id = tb_SSBB.Bill_Id)left join tb_parts  on  tb_SSBB.Parts_Id =tb_parts.parts_id)left join tb_modle on tb_parts.modle_id =tb_modle.modle_id where bill_date  between  to_date(?,'yyyy-mm-dd')and to_date(?,'yyyy-mm-dd')";

			list = dao.getBuyByDateDao(conn, sql, startDate,endDate);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				DBUtil.freeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
}
