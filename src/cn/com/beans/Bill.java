package cn.com.beans;

import java.util.Date;

public class Bill {
	private int bID; //�˵���
	private int amountPayable; //Ӧ����
	private int amountPaid; //�Ѹ���
	private int amountInArrear; //��Ƿ��
	private int bFlog; //�˵���� STOCK = "����" SELL = "����" CLIENTBACK = "�˿��˻�" " BACK = "��˾�˻�";
	private Date bDate; //�˵�����
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
