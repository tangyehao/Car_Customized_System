package cn.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.beans.Warehouse;
import cn.com.dao.WarehouseManageDaoInf;
import cn.com.db.DBUtil;
import cn.com.dto.WarePartsInfoDto;
import cn.com.dto.WareUserDto;
import cn.com.dto.partChangeInfoDto;


public class WarehouseManageDaoImpl implements WarehouseManageDaoInf{
	public List<partChangeInfoDto> getPartsChangeAll(Connection conn, String sql) {
		// TODO Auto-generated method stub
		List<partChangeInfoDto> list = new ArrayList<partChangeInfoDto>();
		partChangeInfoDto pci = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				pci = new partChangeInfoDto();
				pci.setParts_id(rs.getInt("parts_id"));
				pci.setParts_name(rs.getString("parts_name"));
				pci.setParts_num(rs.getInt("parts_num"));
				pci.setUser_name(rs.getString("user_name"));
				pci.setUserphone(rs.getString("user_phone"));
				pci.setFlog(rs.getString("flog_name"));
				list.add(pci);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeResultSet(rs);
				DBUtil.freeStatement(pstm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<partChangeInfoDto> getPartsChangeByPartsName(Connection conn, String sql, String parts_name1) {
		// TODO Auto-generated method stub
		List<partChangeInfoDto> list = new ArrayList<partChangeInfoDto>();
		partChangeInfoDto pci= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,"%"+parts_name1+"%");
			rs = pstm.executeQuery();
			while (rs.next()) {
				pci = new partChangeInfoDto();
				pci.setParts_id(rs.getInt("parts_id"));
				pci.setParts_name(rs.getString("parts_name"));
				pci.setParts_num(rs.getInt("parts_num"));
				pci.setUser_name(rs.getString("user_name"));
				pci.setUserphone(rs.getString("user_phone"));
				pci.setFlog(rs.getString("flog_name"));
				
				list.add(pci);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeResultSet(rs);
				DBUtil.freeStatement(pstm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	@Override
	public List<WarehouseManageDaoInf> WarehouseExport(Connection con, String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean WarehouseAdd(Connection con, String sql, Warehouse w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean WarehouseUpdate(Connection con, String sql, Warehouse w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WarePartsInfoDto> getAllWareInfoDAO(Connection conn, String sql) {
		// TODO Auto-generated method stub
		List<WarePartsInfoDto> list = new ArrayList<WarePartsInfoDto>();
		WarePartsInfoDto wpi = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				wpi = new WarePartsInfoDto();
				wpi.setParts_id(rs.getInt("parts_id"));
				wpi.setParts_name(rs.getString("parts_name"));
				wpi.setModle_type(rs.getString("modle_type"));
				wpi.setPurchase_price(rs.getInt("purchase_price"));
				wpi.setSelling_price(rs.getInt("Selling_price"));
				wpi.setModle_capacity(rs.getInt("modle_capacity"));
				/*ab.setPresetPrice(rs.getInt("pc_presetprice"));
				ab.setHuojia(rs.getString("pc_huojia"));
				ab.setUnit(rs.getString("pc_unit"));
				ab.setModel(rs.getString("pc_model"));
				ab.setColor(rs.getString("pc_color"));*/
				
				list.add(wpi);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeResultSet(rs);
				DBUtil.freeStatement(pstm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<WarePartsInfoDto> getPartByParts_nameDao(Connection conn, String sql, String parts_name) {
		// TODO Auto-generated method stub
		List<WarePartsInfoDto> list = new ArrayList<WarePartsInfoDto>();
		WarePartsInfoDto wpi= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			//int i = 1;
		/*	if(!pc_id.equals("")){
				pstm.setString(i, "%"+pc_id+"%");
				i++;
			}*/
			
				pstm.setString(1,"%"+parts_name+"%");
			
			rs = pstm.executeQuery();
			while (rs.next()) {
				wpi = new WarePartsInfoDto();
				wpi.setParts_id(rs.getInt("parts_id"));
				wpi.setParts_name(rs.getString("parts_name"));
				wpi.setModle_type(rs.getString("modle_type"));
				wpi.setPurchase_price(rs.getInt("purchase_price"));
				wpi.setSelling_price(rs.getInt("Selling_price"));
				wpi.setModle_capacity(rs.getInt("modle_capacity"));
				list.add(wpi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeResultSet(rs);
				DBUtil.freeStatement(pstm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<WarePartsInfoDto> getPartStatByParts_nameDao(Connection conn, String sql, String parts_name) {
		// TODO Auto-generated method stub
		List<WarePartsInfoDto> list = new ArrayList<WarePartsInfoDto>();
		WarePartsInfoDto wpi= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			//int i = 1;
		/*	if(!pc_id.equals("")){
				pstm.setString(i, "%"+pc_id+"%");
				i++;
			}*/
			
				pstm.setString(1,"%"+parts_name+"%");
			
			rs = pstm.executeQuery();
			while (rs.next()) {
				wpi = new WarePartsInfoDto();
				wpi.setParts_id(rs.getInt("parts_id"));
				wpi.setParts_name(rs.getString("parts_name"));
				wpi.setPurchase_price(rs.getInt("purchase_price"));
				wpi.setSelling_price(rs.getInt("Selling_price"));
				wpi.setModle_capacity(rs.getInt("modle_capacity"));
				wpi.setParts_num(rs.getInt("parts_num"));
				list.add(wpi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeResultSet(rs);
				DBUtil.freeStatement(pstm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<WarePartsInfoDto> getAllWareStatInfoDAO(Connection conn, String sql) {
		// TODO Auto-generated method stub
		List<WarePartsInfoDto> list = new ArrayList<WarePartsInfoDto>();
		WarePartsInfoDto wpi = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				wpi = new WarePartsInfoDto();
				wpi.setParts_id(rs.getInt("parts_id"));
				wpi.setParts_name(rs.getString("parts_name"));
				//wpi.setModle_type(rs.getString("modle_type"));
				wpi.setPurchase_price(rs.getInt("purchase_price"));
				wpi.setSelling_price(rs.getInt("Selling_price"));
				wpi.setModle_capacity(rs.getInt("modle_capacity"));
				wpi.setParts_num(rs.getInt("parts_num"));
				/*ab.setPresetPrice(rs.getInt("pc_presetprice"));
				ab.setHuojia(rs.getString("pc_huojia"));
				ab.setUnit(rs.getString("pc_unit"));
				ab.setModel(rs.getString("pc_model"));
				ab.setColor(rs.getString("pc_color"));*/
				
				list.add(wpi);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeResultSet(rs);
				DBUtil.freeStatement(pstm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<WareUserDto> getWareHouseInfoDao(Connection conn, String sql) {
		// TODO Auto-generated method stub
		List<WareUserDto> list = new ArrayList<WareUserDto>();
		WareUserDto wud = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				wud = new WareUserDto();
				wud.setWareID((rs.getInt("warehouse_id")));
				wud.setWareName(rs.getString("warehouse_name"));
				wud.setWareCap(rs.getInt("warehouse_capacity"));
				wud.setWareAddress(rs.getString("warehouse_address"));
				wud.setWareUser(rs.getInt("user_id"));

				list.add(wud);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeResultSet(rs);
				DBUtil.freeStatement(pstm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public boolean validateByWarehouseId(Connection conn, String sql, int warehosue_id) {
		// TODO Auto-generated method stub
		boolean bool = false;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,warehosue_id);
			rs = pstm.executeQuery();
			bool = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeResultSet(rs);
				DBUtil.freeStatement(pstm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return bool;	
	}

	@Override
	public boolean addWareUser(Connection conn, String sql, WareUserDto wud) {
		// TODO Auto-generated method stub
		boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, wud.getWareID());
			pstm.setString(2, wud.getWareName());
			pstm.setInt(3, wud.getWareCap());
			pstm.setInt(4, wud.getWarehouse_surplus());
			pstm.setInt(5, wud.getWarehouse_state_id());
			pstm.setString(6, wud.getWareAddress());
			pstm.setInt(7, wud.getWareUser());
			pstm.setInt(8, wud.getInventory_id());
			
			int len = pstm.executeUpdate();
			if(len > 0) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeStatement(pstm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}

	@Override
	public boolean updateWareUser(Connection conn, String sql, WareUserDto wud) {
		// TODO Auto-generated method stub
		boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, wud.getWareName());
			pstm.setInt(2, wud.getWareCap());
			pstm.setString(3, wud.getWareAddress());	
			pstm.setInt(4, wud.getWareUser());
			pstm.setInt(5, wud.getWareID());
			int len = pstm.executeUpdate();
			if (len > 0) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeStatement(pstm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}

	@Override
	public boolean delWareUserInfoDAO(Connection conn, String sql, int wareid) {
		// TODO Auto-generated method stub
		Boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, wareid);
			int len = pstm.executeUpdate();
			if(len > 0) {
				bool = true;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstm != null) {
				try {
					DBUtil.freeStatement(pstm);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return bool;
	}
	
	
}
