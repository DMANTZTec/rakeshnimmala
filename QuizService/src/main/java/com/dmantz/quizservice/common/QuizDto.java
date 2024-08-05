package com.dmantz.quizservice.common;

public class QuizDto {

	private String language;
	private int numq;
	private String title;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getNumq() {
		return numq;
	}

	public void setNumq(int numq) {
		this.numq = numq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
