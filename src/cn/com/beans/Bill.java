package cn.com.beans;

import java.util.Date;

public class Bill {
	private int bID; //账单号
	private int amountPayable; //应付款
	private int amountPaid; //已付款
	private int amountInArrear; //拖欠款
	private int bFlog; //账单标记 STOCK = "进货" SELL = "销售" CLIENTBACK = "顾客退货" " BACK = "公司退货";
	private Date bDate; //账单日期
	public int getbID() {
		return bID;
	}
	public void setbID(int bID) {
		this.bID = bID;
	}
	public int getAmountPayable() {
		return amountPayable;
	}
	public void setAmountPayable(int amountPayable) {
		this.amountPayable = amountPayable;
	}
	public int getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}
	public int getAmountInArrear() {
		return amountInArrear;
	}
	public void setAmountInArrear(int amountInArrear) {
		this.amountInArrear = amountInArrear;
	}
	public int getbFlog() {
		return bFlog;
	}
	public void setbFlog(int bFlog) {
		this.bFlog = bFlog;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	
}
