package com.project.bean;

public class CustomerBean {
	private Integer customerId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private String email;
	private String phoneNo;
	private String password;
	
	public CustomerBean() {
		super();
	}
	
	public CustomerBean(Integer customerId, String firstName, String email) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.email = email;
	}
	
	public CustomerBean(Integer customerId, String firstName, String lastName, Integer age, String gender, String email,
			String phoneNo, String password) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
	}
	
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "CustomerBean [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", gender=" + gender + ", email=" + email + ", phoneNo=" + phoneNo + ", password="
				+ password + "]";
	}

}
