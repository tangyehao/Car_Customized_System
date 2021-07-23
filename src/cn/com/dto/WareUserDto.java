package cn.com.dto;

public class WareUserDto {
	private int WareID;
	private String WareName;
	private int WareCap;
	private int WareUser;
	private String WareAddress;
	private int warehouse_surplus;
	private int warehouse_state_id;
	private int inventory_id;

	public WareUserDto(){

	}


	public int getWarehouse_surplus() {
		return warehouse_surplus;
	}


	public void setWarehouse_surplus(int warehouse_surplus) {
		this.warehouse_surplus = warehouse_surplus;
	}


	public int getWarehouse_state_id() {
		return warehouse_state_id;
	}


	public void setWarehouse_state_id(int warehouse_state_id) {
		this.warehouse_state_id = warehouse_state_id;
	}


	public int getInventory_id() {
		return inventory_id;
	}


	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}


	public int getWareID() {
		return WareID;
	}


	public void setWareID(int wareID) {
		WareID = wareID;
	}


	public String getWareName() {
		return WareName;
	}


	public void setWareName(String wareName) {
		WareName = wareName;
	}


	public int getWareCap() {
		return WareCap;
	}


	public void setWareCap(int wareCap) {
		WareCap = wareCap;
	}


	public int getWareUser() {
		return WareUser;
	}


	public void setWareUser(int wareUser) {
		WareUser = wareUser;
	}


	public String getWareAddress() {
		return WareAddress;
	}


	public void setWareAddress(String wareAddress) {
		WareAddress = wareAddress;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getWareID()+"";
	}


}
