package cn.com.services;

import cn.com.beans.Bill;
import cn.com.beans.Parts;

public interface CommodityManageServiseInf {
	//��Ʒ����

	boolean Stock(String user_name,String firm_name,Parts p,int num,Bill b);//��������
	boolean Back(String user_name,String firm_name,Parts p,int num,Bill b);//�˻�
	boolean Sell(String user_name,String Cliend_name,Parts p,int num,Bill b);//����
	boolean CliendBack(String user_name,String Cliend_name,Parts p,int num,Bill b);//�˿��˻�
	
}
