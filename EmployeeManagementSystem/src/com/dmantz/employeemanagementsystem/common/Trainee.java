package com.dmantz.employeemanagementsystem.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Trainee {
	private int traineeId;
	private String traineeName;
	private String traineeEmail;
	private List<Trainee_Course> listOfTraineeCourse;

	public List<Trainee_Course> getListOfTraineeCourse() {
		return listOfTraineeCourse;
	}

	public void setListOfTraineeCourse(List<Trainee_Course> listOfTraineeCourse) {
		this.listOfTraineeCourse = listOfTraineeCourse;
	}

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getTraineeEmail() {
		return traineeEmail;
	}

	public void setTraineeEmail(String traineeEmail) {
		this.traineeEmail = traineeEmail;
	}
	
	

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName=" + traineeName + ", traineeEmail=" + traineeEmail
				+ "]";
	}

	public Trainee traineeDetails(int traineeId) throws SQLException {
		Trainee trainee = new Trainee();
		

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagementSystem",
					"root", "Rakesh@1999");
			PreparedStatement statement = connection.prepareStatement("select * from Trainee where traineeId=?");
			statement.setInt(1, traineeId);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				trainee.setTraineeId(result.getInt("traineeId"));
				trainee.setTraineeName(result.getString("traineeName"));
				trainee.setTraineeEmail(result.getString("traineeEmail"));
				System.out.println(
						trainee.getTraineeId() + " " + trainee.getTraineeName() + " " + trainee.getTraineeEmail());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trainee;
	}

	public Course assignedCourses(int traineeId) throws Exception {

		Course course = new Course();
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagementSystem",
					"root", "Rakesh@1999");
			PreparedStatement statement = connection.prepareStatement(
					"select * from Trainee_Course tc inner join course c on tc.cid=c.courseId where tId=?");
			statement.setInt(1, traineeId);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				course.setCourseId(result.getInt("courseId"));
				course.setCourseName(result.getString("courseName"));
				System.out.println(course.getCourseId() + " " + course.getCourseName());

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;

	}

	public void allCourses() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagementSystem",
					"root", "Rakesh@1999");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from Course");

			while (result.next()) {
				int courseId = result.getInt("courseId");
				String coursename = result.getString("coursename");

				System.out.println(courseId + " " + coursename);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
