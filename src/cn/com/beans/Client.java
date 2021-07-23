package cn.com.beans;

public class Client {
	private int cID; //客户ID
	private String cName; //客户姓名
	private String cAddress; //客户地址
	private String cPhone; //客户电话
	private String cNote; // 备注
	public int getcID() {
		return cID;
	}
	public String getcName() {
		return cName;
	}
	public String getcAddress() {
		return cAddress;
	}
	public String getcPhone() {
		return cPhone;
	}
	public String getcNote() {
		return cNote;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}
	public void setcNote(String cNote) {
		this.cNote = cNote;
	}

	@Override
	public String toString() {
		return  cID + "";
	}
}
