package cn.com.dao;

import java.sql.Connection;
import java.util.List;

import cn.com.beans.Client;
import cn.com.beans.Firm;

public interface ClientInfoDAOInf {
	List<Client> getAllClientInfoDAO(Connection conn, String sql);
	boolean updateClientInfoDAO(Connection conn, String sql, Client cb);
	boolean delClientInfoDAO(Connection conn, String sql, int clientId);
	boolean validateByClientIdDAO(Connection conn, String sql, int clientId);
	boolean addClientInfoDAO(Connection conn, String sql, Client cb);
	List<Client> getClientInfoByClientNameDAO(Connection conn, String sql, String clientName);

}
