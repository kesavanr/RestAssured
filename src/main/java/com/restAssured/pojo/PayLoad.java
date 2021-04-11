package com.restAssured.pojo;

public class PayLoad {
	private String name;
	private int age;
	private String Professional;
	private String framework;
	private int totalExp;
	
	public PayLoad(String name, int age, String Professional, String framework, int totalExp) {
		this.name=name;
		this.age=age;
		this.Professional=Professional;
		this.framework=framework;
		this.totalExp=totalExp;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getProfessional() {
		return Professional;
	}
	public void setProfessional(String professional) {
		Professional = professional;
	}
	public String getFramework() {
		return framework;
	}
	public void setFramework(String framework) {
		this.framework = framework;
	}
	public int getTotalExp() {
		return totalExp;
	}
	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}
	
	
}
