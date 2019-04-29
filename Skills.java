package com.niit.SkillMappingBackEnd.Entity;

public class Skills {
	int empid ;
	int id ;
	String skillname ;
	String certification;
	int experinceyears;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSkillname() {
		return skillname;
	}
	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public int getExperinceyears() {
		return experinceyears;
	}
	public void setExperinceyears(int experinceyears) {
		this.experinceyears = experinceyears;
	}

}
