package com.dmantz.employeemanagementsystem.common;

import java.util.ArrayList;
import java.util.List;

public class Module {
	private int moduleId;
	private String moduleName;
	private List<Topic> listOfTopics;

	public List<Topic> getListOfTopics() {
		return listOfTopics;
	}

	public void setListOfTopics(List<Topic> listOfTopics) {
		this.listOfTopics = listOfTopics;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

}
