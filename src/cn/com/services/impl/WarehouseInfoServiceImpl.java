package cn.com.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.Warehouse;
import cn.com.dao.WarehouseManageDaoInf;
import cn.com.dao.impl.WarehouseManageDaoImpl;
import cn.com.db.DBUtil;
import cn.com.dto.WarePartsInfoDto;
import cn.com.dto.WareUserDto;
import cn.com.dto.partChangeInfoDto;
import cn.com.services.WarehouseInfoServiceInf;

public class WarehouseInfoServiceImpl implements WarehouseInfoServiceInf{
	
	private WarehouseManageDaoInf dao;
	
	public WarehouseInfoServiceImpl(){
		dao = new WarehouseManageDaoImpl();
	}

	@Override
	public List<Warehouse> warehouseExport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean warehouseAdd(Warehouse w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean warehouseUpdate(Warehouse w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WarePartsInfoDto> getAllWarePartInfoService() {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<WarePartsInfoDto> list = null;
		String sql = "select parts_id,parts_name,tb_modle.modle_type,purchase_price,selling_price,modle_capacity from tb_modle left join tb_parts on tb_modle.modle_id = tb_parts.modle_id";
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			list = dao.getAllWareInfoDAO(conn, sql);
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
	public List<WarePartsInfoDto> getWarePartInfoByParts_nameServiceImpl(String parts_name) {
		// TODO Auto-generated method stub
		List<WarePartsInfoDto> list = new ArrayList<WarePartsInfoDto>();
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select parts_id,parts_name,tb_modle.modle_type,purchase_price,selling_price,modle_capacity from tb_modle left join tb_parts on tb_modle.modle_id = tb_parts.modle_id where parts_name like ?";
			/*if(!(pc_id.equals("") && pc_name.equals(""))){
				sql += "where";
			}
			boolean bool = false;
			if(!pc_id.equals("")){
				sql += "pc_id like ? ";
				bool = true;
			}
			if(!pc_name.equals("")){
				if(bool){
					sql += "and pc_name like ? ";
				}else{
					sql += "pc_name like ? ";
				}	
			}*/
			list = dao.getPartByParts_nameDao(conn, sql, parts_name);
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
	public List<WarePartsInfoDto> getWareStatInfoByParts_nameServiceImpl(String parts_name) {
		// TODO Auto-generated method stub
		List<WarePartsInfoDto> list = new ArrayList<WarePartsInfoDto>();
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select parts_id,parts_name,purchase_price,selling_price,modle_capacity,parts_num from ((tb_modle left join tb_parts on tb_modle.modle_id = tb_parts.modle_id) left join tb_inventory on tb_parts.parts_id = tb_inventory.parts_id) where parts_name like ?";
			/*if(!(pc_id.equals("") && pc_name.equals(""))){
				sql += "where";
			}
			boolean bool = false;
			if(!pc_id.equals("")){
				sql += "pc_id like ? ";
				bool = true;
			}
			if(!pc_name.equals("")){
				if(bool){
					sql += "and pc_name like ? ";
				}else{
					sql += "pc_name like ? ";
				}	
			}*/
			list = dao.getPartStatByParts_nameDao(conn, sql, parts_name);
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
	public List<WarePartsInfoDto> getAllWareStatPartInfoService() {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<WarePartsInfoDto> list = null;
		String sql = "select parts_id,parts_name,purchase_price,selling_price,modle_capacity,parts_num from ((tb_modle left join tb_parts on tb_modle.modle_id = tb_parts.modle_id) left join tb_inventory on tb_parts.parts_id = tb_inventory.parts_id)";
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			list = dao.getAllWareStatInfoDAO(conn, sql);
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
	public List<WareUserDto> getWareHouseAllInfo() {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<WareUserDto> list = null;
		//String sql = "select warehouse_name,user_name,user_phone,warehouse_address from tb_warehouse w left join tb_user u on w.user_id = u.user_id";
		String sql = "select warehouse_id,warehouse_name,warehouse_capacity,warehouse_address,user_id from tb_warehouse";
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			list = dao.getWareHouseInfoDao(conn, sql);
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
	public boolean validateByWarehouseIdService(int warehouse_id) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select * from tb_warehouse where warehouse_id =?";
			bool = dao.validateByWarehouseId(conn, sql, warehouse_id);
			if(bool) {
				conn.commit();
			}else {
				conn.rollback();
			}
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

		return bool;
	}

	@Override
	public boolean addWareService(WareUserDto wud) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql1 = "select * from tb_warehouse where warehouse_id = ?";
			bool = dao.validateByWarehouseId(conn, sql1, wud.getWareID());
			if(bool) {
				conn.rollback();
				return bool;
			}
			if(wud.getWareID() == 0) {
				return bool;
			}
			if(wud == null) {
				return bool;
			}
			String sql2 = "insert into tb_warehouse values(?,?,?,?,?,?,?,?)";
			bool = dao.addWareUser(conn, sql2, wud);
			if(bool) {
				conn.commit();
			}else {
				conn.rollback();
			}
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
		return bool;
	}

	@Override
	public boolean updateWareUserService(WareUserDto wud) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "update tb_warehouse set warehouse_name = ?,warehouse_capacity = ?,warehouse_address = ?,user_id =  ? where warehouse_id = ?";
			//String sql = "update tb_warehouse set warehouse_address = ? where warehouse_name = ?";
			bool = dao.updateWareUser(conn, sql, wud);
			if(bool) {
				conn.commit();
			} else {
				conn.rollback();
			}
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
		return bool;
	}

	@Override
	public boolean delClientInfoService(int wareid) {
		// TODO Auto-generated method stub
		boolean bool = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "delete from tb_warehouse where warehouse_id = ?";
			bool = dao.delWareUserInfoDAO(conn, sql, wareid);
			if(bool) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
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
			if(conn != null) {
				try {
					DBUtil.freeConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return bool;
	}

	public List<partChangeInfoDto> getPartsChangeInfoAllService() {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<partChangeInfoDto> list = null;
		String sql = "select  parts_id,parts_num,parts_name,user_name,user_phone,flog_name from ((tb_ssbb_flog left join tb_ssbb on tb_ssbb_flog.flog_id = tb_ssbb.flog_id)left join tb_parts on tb_ssbb.parts_id = tb_parts.parts_id) left join tb_user on tb_ssbb.user_id = tb_user.user_id";
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			list = dao.getPartsChangeAll(conn, sql);
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
	public List<partChangeInfoDto> getPartsChangeInfoByPartsName(String parts_name1) {
		// TODO Auto-generated method stub
		List<partChangeInfoDto> list = new ArrayList<partChangeInfoDto>();
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select  parts_id,parts_num,parts_name,user_name,user_phone,flog_name from ((tb_ssbb_flog left join tb_ssbb on tb_ssbb_flog.flog_id = tb_ssbb.flog_id)left join tb_parts on tb_ssbb.parts_id = tb_parts.parts_id) left join tb_user on tb_ssbb.user_id = tb_user.user_id where parts_name like ?";
			list = dao.getPartsChangeByPartsName(conn, sql, parts_name1);
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
