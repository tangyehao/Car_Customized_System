package cn.com.beans;

public class Firm {
	private int fID; //¹«Ë¾Ãû³Æ
	private String fName;
	private String fAddress;
	private String fPhone;
	private String fNote;
	public int getfID() {
		return fID;
	}
	public void setfID(int fID) {
		this.fID = fID;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfAddress() {
		return fAddress;
	}
	public void setfAddress(String fAddress) {
		this.fAddress = fAddress;
	}
	public String getfPhone() {
		return fPhone;
	}
	public void setfPhone(String fPhone) {
		this.fPhone = fPhone;
	}
	public String getfNote() {
		return fNote;
	}
	public void setfNote(String fNote) {
		this.fNote = fNote;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getfName();
	}
}
