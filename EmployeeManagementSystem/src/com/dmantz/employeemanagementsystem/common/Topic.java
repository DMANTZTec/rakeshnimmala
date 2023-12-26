package com.dmantz.employeemanagementsystem.common;

import java.util.ArrayList;
import java.util.List;

public class Topic {
	private int topicId;
	private String topicName;
	private ArrayList<Module> listOfTopics;

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

}
