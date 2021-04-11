package com.restAssured.pojo;

import java.util.List;

public class PayLoadAdvanced {
	private String name;
	private int age;
	private String professional;
	private List<String> framework;
	private int totalExp;
	
	public PayLoadAdvanced(String name, int age, String professional, List<String> framework, int totalExp) {
		this.name=name;
		this.age= age;
		this.professional=professional;
		this.framework= framework;
		this.totalExp =totalExp;
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
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public List<String> getFramework() {
		return framework;
	}
	public void setFramework(List<String> framework) {
		this.framework = framework;
	}
	public int getTotalExp() {
		return totalExp;
	}
	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}
	
	
}
