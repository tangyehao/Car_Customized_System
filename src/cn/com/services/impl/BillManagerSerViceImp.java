package cn.com.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.com.beans.Bill;
import cn.com.dao.BillBaseDaoInf;
import cn.com.dao.impl.BillBaseDaoImp;
import cn.com.dao.impl.BillInfoManageDaoimpl;
import cn.com.db.DBUtil;
import cn.com.dto.BillViewDto;
import cn.com.dto.PartDto;
import cn.com.services.BillManageServiceInf;

public class BillManagerSerViceImp  implements BillManageServiceInf {
	private BillBaseDaoInf dao;
	private BillInfoManageDaoimpl dao1;
	
	public BillManagerSerViceImp(){
		dao = new BillBaseDaoImp();
	}
	@Override
	public List<BillViewDto> getbillByIDService() {
		List<BillViewDto> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select tb_bill.bill_id ,firm_name,bill_payable ,bill_paid,bill_in_arrear ,user_name ,flog_name ,bill_date   from ((((tb_bill left join tb_SSBB on tb_bill.bill_id = tb_SSBB.Bill_Id )left join tb_firm on tb_SSBB.firm_id =tb_firm.firm_id))left join  tb_user  on tb_SSBB.User_Id = tb_user.user_id) left join tb_bill_flog on tb_bill.flog_id = tb_bill_flog.flog_id  ";
			list = dao.getBillBaseByBillIdDao(conn, sql);
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
	@Override
	public List<BillViewDto> getbillByIDService(int Id) {
		List<BillViewDto> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select tb_bill.bill_id ,firm_name,bill_payable ,bill_paid,bill_in_arrear ,user_name ,flog_name ,bill_date    from ((((tb_bill left join tb_SSBB on tb_bill.bill_id = tb_SSBB.Bill_Id )left join tb_firm on tb_SSBB.firm_id =tb_firm.firm_id))left join  tb_user  on tb_SSBB.User_Id = tb_user.user_id) left join tb_bill_flog on tb_bill.flog_id =  tb_bill_flog.flog_id where tb_bill.bill_id = ?";
			list = dao.getBillBaseByBillIdDao(conn, sql, Id);
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
	@Override
	public List<PartDto> getPartSerice(int value) {
		// TODO Auto-generated method stub
		List<PartDto> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = " select tb_parts.parts_id,parts_name,parts_color,parts_num,purchase_price from ((tb_bill left join tb_SSBB on tb_bill.bill_id = tb_SSBB.Bill_Id )left join tb_parts on tb_SSBB.parts_id  =tb_parts.parts_id)left join tb_modle on tb_parts.modle_id = tb_modle.modle_id where tb_bill.bill_id = ?";
			list = dao.getPartDao(conn, sql ,value);
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
	public boolean billAdd(Bill bill){
		boolean bool = false;
		Connection con = null;
		String sql = "insert into tb_bill values(?,?,?,?,?,?)";
		try {
			con = DBUtil.getConn();
			con.setAutoCommit(false);
			bool = dao1.billAdd(con, sql, bill);
			if(bool) {
				con.commit();
			} else {
				con.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}
}
	


