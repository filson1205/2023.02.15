package com.greedy.member.model.dto;

public class MemberDTO {

	private int no;
	private String id;
	private String pwd;
	private String gender;
	private String name;
	private String email;
	private String phone;
	private String address;
	private int age;
	private String enrollDate;
	
	public MemberDTO() {}

	public MemberDTO(int no, String id, String pwd, String gender, String name, String email, String phone,
			String address, int age, String enrollDate) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.gender = gender;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.age = age;
		this.enrollDate = enrollDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", id=" + id + ", pwd=" + pwd + ", gender=" + gender + ", name=" + name
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + ", age=" + age + ", enrollDate="
				+ enrollDate + "]";
	}
	
	
}
