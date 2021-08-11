package entity;

public class User {
	private int id;
	private String uName;
	private String uPwd;
	private String uRealName;
	private String uSex;
	private int uAge;
	private String uPhone;
	private int actor;
	private int uBorrow;
	private int uMaxBorrow;
	
	public int getuMaxBorrow() {
		return uMaxBorrow;
	}
	public void setuMaxBorrow(int uMaxBorrow) {
		this.uMaxBorrow = uMaxBorrow;
	}
	public int getuBorrow() {
		return uBorrow;
	}
	public void setuBorrow(int uBorrow) {
		this.uBorrow = uBorrow;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getuSex() {
		return uSex;
	}
	public void setuSex(String uSex) {
		this.uSex = uSex;
	}
	public int getuAge() {
		return uAge;
	}
	public void setuAge(int uAge) {
		this.uAge = uAge;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public int getActor() {
		return actor;
	}
	public void setActor(int actor) {
		this.actor = actor;
	}
	public String getuRealName() {
		return uRealName;
	}
	public void setuRealName(String uRealName) {
		this.uRealName = uRealName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uName=" + uName + ", uPwd=" + uPwd + ", uRealName=" + uRealName + ", uSex=" + uSex
				+ ", uAge=" + uAge + ", uPhone=" + uPhone + ", actor=" + actor + ", uBorrow=" + uBorrow + "]";
	}
	
	
}
