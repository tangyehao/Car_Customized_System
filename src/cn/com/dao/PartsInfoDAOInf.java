package cn.com.dao;

import java.sql.Connection;
import java.util.List;

import cn.com.beans.Parts;
import cn.com.dto.partChangeInfoDto;


public interface PartsInfoDAOInf {
	List<Parts> getAllPartsInfoDAO(Connection conn, String sql);
	Boolean addPartsInfoDAO(Connection conn, String sql, Parts pb);
	Boolean validateByPartsIdDAO(Connection conn, String sql, int pbId);
	boolean updatePartsInfoDAO(Connection conn, String sql, Parts pb);
	boolean delPartsInfoByPartsIdDAO(Connection conn, String sql, int partsId);
	List<Parts> getPartsInfoByPartsNameDAO(Connection conn, String sql, String partsName);
	List<partChangeInfoDto> getPartsChangeByPartsName(Connection conn, String sql, String parts_name1);
	List<partChangeInfoDto> getPartsChangeAll(Connection conn, String sql);

	
	
	
}
