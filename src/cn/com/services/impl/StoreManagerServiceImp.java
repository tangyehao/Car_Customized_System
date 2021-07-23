package cn.com.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import cn.com.dao.StoreDaoInf;
import cn.com.dao.impl.StoreDaoImp;
import cn.com.db.DBUtil;
import cn.com.dto.StoreStateDto;
import cn.com.services.StoreStateServiceInf;

public class StoreManagerServiceImp implements StoreStateServiceInf {
	private StoreDaoInf dao;
	
	public StoreManagerServiceImp(){
		dao = new StoreDaoImp();
	}
	@Override
	public List<StoreStateDto> getStoreStateByDateService(String startDate, String endDate) {
		List<StoreStateDto> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select tb_inventory .parts_num ,purchase_price  from ((tb_inventory left join tb_inventory_change on tb_inventory.parts_id = tb_inventory_change.parts_id) left join  tb_parts on tb_inventory_change.parts_id = tb_parts.parts_id) left join tb_modle on tb_parts.modle_id = tb_modle.modle_id where change_date  between  to_date(?,'yyyy-mm-dd')and to_date(?,'yyyy-mm-dd')";

			list = dao.getStoreByDate(conn, sql, startDate,endDate);
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
