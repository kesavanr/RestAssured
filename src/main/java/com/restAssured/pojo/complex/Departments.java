package com.restAssured.pojo.complex;

public class Departments {
	private int developers;
	private int manualtesters;
	private int automations;
	
	public Departments(int developers, int manualtesters, int automations) {
		this.developers=developers;
		this.manualtesters=manualtesters;
		this.automations=automations;
	}
	
	public int getDevelopers() {
		return developers;
	}
	public void setDevelopers(int developers) {
		this.developers = developers;
	}
	public int getManualtesters() {
		return manualtesters;
	}
	public void setManualtesters(int manualtesters) {
		this.manualtesters = manualtesters;
	}
	public int getAutomations() {
		return automations;
	}
	public void setAutomations(int automations) {
		this.automations = automations;
	}
	
}
