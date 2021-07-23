package cn.com.beans;

public class User {
	private int uID;
	private String uNo;
	private String uName;
	private String uPwd;
	private String uEmail;
	private String uPhone;
	private String uJob;
	private String uSex;
	private String uAge;
	private String uAddress;
    private String uState;
    
    
	public String getuNo() {
		return uNo;
	}
	public void setuNo(String uNo) {
		this.uNo = uNo;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmil) {
		this.uEmail = uEmil;
	}
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	public String getuJob() {
		return uJob;
	}
	public void setuJob(String uJob) {
		this.uJob = uJob;
	}
	public String getuSex() {
		return uSex;
	}
	public void setuSex(String uSex) {
		this.uSex = uSex;
	}
	public String getuAge() {
		return uAge;
	}
	public void setuAge(String uAge) {
		this.uAge = uAge;
	}
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public String getuState() {
		return uState;
	}
	public void setuState(String uState) {
		this.uState = uState;
	}

	@Override
	public String toString() {
		return uName;
	}
}
