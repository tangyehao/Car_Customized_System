package cn.com.dto;

public class partChangeInfoDto {
	private int parts_id;
	private String parts_name;
	private int parts_num;
	private String user_name;
	private String userphone;
	private String flog;
	
	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
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

	public int getParts_num() {
		return parts_num;
	}

	public void setParts_num(int parts_num) {
		this.parts_num = parts_num;
	}

	public String getFlog() {
		return flog;
	}

	public void setFlog(String flog) {
		this.flog = flog;
	}

	public partChangeInfoDto(){
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getParts_id()+"";
	}
}
