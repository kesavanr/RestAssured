package com.restAssured.pojo.complex;

public class Projects {
	private String project;
	private Departments departments;
	
	public Projects(String project, Departments departments) {
		this.project=project;
		this.departments=departments;
	}
	
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public Departments getDepartments() {
		return departments;
	}
	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

}
