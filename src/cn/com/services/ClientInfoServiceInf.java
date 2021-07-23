package cn.com.services;

import java.util.List;

import cn.com.beans.Client;

public interface ClientInfoServiceInf {
	List<Client> getAllClientInfoService();
	Boolean updateClientInfoService(Client cb);
	Boolean delClientInfoService(int clientId);
	Boolean validateByClientIdService(int clientId);
	Boolean addClientInfoService(Client cb);
	List<Client> getClientInfoByClientNameService(String clientName);
}
