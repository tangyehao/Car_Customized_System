package cn.com.beans;

public class Parts {
	private int pID;
	private String pName;
	private String pColour;
	private int pModle;
	private String pNote;
	public int getpID() {
		return pID;
	}
	public void setpID(int pID) {
		this.pID = pID;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpColour() {
		return pColour;
	}
	public void setpColour(String pColour) {
		this.pColour = pColour;
	}
	public int getpModle() {
		return pModle;
	}
	public void setpModle(int pModle) {
		this.pModle = pModle;
	}
	public String getpNote() {
		return pNote;
	}
	public void setpNote(String pNote) {
		this.pNote = pNote;
	}

	@Override
	public String toString() {
		return  pID + "";
	}
}
