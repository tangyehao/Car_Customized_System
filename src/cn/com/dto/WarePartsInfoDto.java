package cn.com.dto;

public class WarePartsInfoDto {
	private int parts_id;
	private String parts_name;
	private String modle_type;
	private int purchase_price;
	private int selling_price;
	private int modle_capacity;
	private int parts_num;
	
	public WarePartsInfoDto(){
		
	}

	
	public int getParts_num() {
		return parts_num;
	}


	public void setParts_num(int parts_num) {
		this.parts_num = parts_num;
	}


	public int getParts_id() {
		return parts_id;
	}

	public void setParts_id(int parts_id) {
		this.parts_id = parts_id;
	}

	public String getParts_name() {
		return parts_name;
	}

	public void setParts_name(String parts_name) {
		this.parts_name = parts_name;
	}

	public String getModle_type() {
		return modle_type;
	}

	public void setModle_type(String modle_type) {
		this.modle_type = modle_type;
	}

	public int getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(int purchase_price) {
		this.purchase_price = purchase_price;
	}

	public int getSelling_price() {
		return selling_price;
	}

	public void setSelling_price(int selling_price) {
		this.selling_price = selling_price;
	}

	public int getModle_capacity() {
		return modle_capacity;
	}

	public void setModle_capacity(int modle_capacity) {
		this.modle_capacity = modle_capacity;
	}

	@Override
	public String toString() {
		return parts_id + "";

	}
}
