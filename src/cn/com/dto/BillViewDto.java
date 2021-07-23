package cn.com.dto;

import cn.com.beans.User;

import java.util.Date;

public class BillViewDto {
	private int bIdDto; //账单号
	private String clientorfactoryDto;
	private String  InventoryDto;
	private String  userDto;
	private double payableDto; //应付款
	private double paidDto; //已付款
	private double InArrearDto; //拖欠款
	private String FlogNameDto; //账单标记 STOCK = "进货" SELL = "销售" CLIENTBACK = "顾客退货" " BACK = "公司退货";
	private Date DateDto; //账单日期
	public int getbIdDto() {
		return bIdDto;
	}
	public void setbIdDto(int bIdDto) {
		this.bIdDto = bIdDto;
	}
	public String getClientorfactoryDto() {
		return clientorfactoryDto;
	}
	public void setClientorfactoryDto(String clientorfactoryDto) {
		this.clientorfactoryDto = clientorfactoryDto;
	}
	public String getInventoryDto() {
		return InventoryDto;
	}
	public void setInventoryDto(String inventoryDto) {
		InventoryDto = inventoryDto;
	}
	public String getUserDto() {
		return userDto;
	}
	public void setUserDto(String userDto) {
		this.userDto = userDto;
	}
	public double getPayableDto() {
		return payableDto;
	}
	public void setPayableDto(double payableDto) {
		this.payableDto = payableDto;
	}
	public double getPaidDto() {
		return paidDto;
	}
	public void setPaidDto(double paidDto) {
		this.paidDto = paidDto;
	}
	public double getInArrearDto() {
		return InArrearDto;
	}
	public void setInArrearDto(double inArrearDto) {
		InArrearDto = inArrearDto;
	}
	public String getFlogNameDto() {
		return FlogNameDto;
	}
	public void setFlogNameDto(String flogNameDto) {
		FlogNameDto = flogNameDto;
	}
	public Date getDateDto() {
		return DateDto;
	}
	public void setDateDto(Date dateDto) {
		DateDto = dateDto;
	}

}
