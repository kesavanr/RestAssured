package com.restAssured.pojo.complex;

import java.util.List;

public class PayLoad {
	private String companyname;
	private String location;
	private String status;
	private List<Projects> projects;
	private int innogration;
	private double annualIncome;
	
	public PayLoad(String companyname, String location, String status, List<Projects> lstprojects, int innogration, double annualIncome) {
		this.companyname=companyname;
		this.location=location;
		this.status=status;
		this.projects = lstprojects;
		this.innogration=innogration;
		this.annualIncome=annualIncome;
	}
	
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Projects> getProjects() {
		return projects;
	}
	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}
	public int getInnogration() {
		return innogration;
	}
	public void setInnogration(int innogration) {
		this.innogration = innogration;
	}
	public double getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(long annualIncome) {
		this.annualIncome = annualIncome;
	}
	
}

