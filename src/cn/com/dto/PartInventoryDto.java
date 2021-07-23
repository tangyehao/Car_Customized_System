package cn.com.dto;

public class PartInventoryDto {
	private String parts_id;
	private String parts_name;
	private String parts_color;
	private int parts_num;
	
	public PartInventoryDto(){
		
	}

	public String getParts_id() {
		return parts_id;
	}

	public void setParts_id(String parts_id) {
		this.parts_id = parts_id;
	}

	public String getParts_name() {
		return parts_name;
	}

	public void setParts_name(String parts_name) {
		this.parts_name = parts_name;
	}

	public String getParts_color() {
		return parts_color;
	}

	public void setParts_color(String parts_color) {
		this.parts_color = parts_color;
	}

	public int getParts_num() {
		return parts_num;
	}

	public void setParts_num(int parts_num) {
		this.parts_num = parts_num;
	}
	
}
