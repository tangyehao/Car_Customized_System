package cn.com.beans;

public class Client {
	private int cID; //�ͻ�ID
	private String cName; //�ͻ�����
	private String cAddress; //�ͻ���ַ
	private String cPhone; //�ͻ��绰
	private String cNote; // ��ע
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
