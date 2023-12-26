package com.dmantz.employeemanagementsystem.common;

public class Trainee_Course {
	private int tcId;
	private int tId;
	private int cId;

	public int getTcId() {
		return tcId;
	}

	public void setTcId(int tcId) {
		this.tcId = tcId;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	@Override
	public String toString() {
		return "Trainee_Course [tcId=" + tcId + ", tId=" + tId + ", cId=" + cId + "]";
	}

}
