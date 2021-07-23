package cn.com.services;

import cn.com.beans.Bill;
import cn.com.beans.Parts;

public interface CommodityManageServiseInf {
	//商品管理

	boolean Stock(String user_name,String firm_name,Parts p,int num,Bill b);//进货方法
	boolean Back(String user_name,String firm_name,Parts p,int num,Bill b);//退货
	boolean Sell(String user_name,String Cliend_name,Parts p,int num,Bill b);//销售
	boolean CliendBack(String user_name,String Cliend_name,Parts p,int num,Bill b);//顾客退货
	
}
