package com.niit.SkillMappingBackEnd.Entity;

public class Users {
	private int EmpId;
	private String name;
	private String dateofbirth;
	private String Gender;
    private String address;
	private String qualification;
	private String emailId;
	private String contactNo;
	private String department;
	private String Supervicer;
	private String password;
	private String role;
	private String Authentication;
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getEmailId() {
				return emailId;
	}
	public void setEmailId(String emailId) {
		//Validation val=new Validation();
		//if(val.validateEmail(emailId))
		{
			this.emailId = emailId;
		}

		
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		//Validation val=new Validation();
		//if(val.validateContactNo(contactNo))
		{
		this.contactNo = contactNo;
	}
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSupervicer() {
		return Supervicer;
	}
	public void setSupervicer(String supervicer) {
		Supervicer = supervicer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAuthentication() {
		return Authentication;
	}
	public void setAuthentication(String authentication) {
		Authentication = authentication;
	}

	

}
