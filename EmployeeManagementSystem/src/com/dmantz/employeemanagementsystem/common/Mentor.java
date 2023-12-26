package com.dmantz.employeemanagementsystem.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mentor {
	private int mentorId;
	private String mentorName;

	public int getMentorId() {
		return mentorId;
	}

	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public Trainee addtrainee(Trainee trainee) {

		try {

			int lastRecordInTraineeTable = getLastRecordOfTaineeId();
			int newRecordId = lastRecordInTraineeTable + 1;
			PreparedStatement statement = getConnection().prepareStatement("insert into Trainee values(?,?,?)");

			statement.setInt(1, newRecordId);
			statement.setString(2, trainee.getTraineeName());
			statement.setString(3, trainee.getTraineeEmail());
			int a = statement.executeUpdate();
			System.out.println("Trainee Added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trainee;
	}

	public Trainee deleteTrainee(int traineeId) {

		Trainee trainee = new Trainee();
		try {

			PreparedStatement statement = getConnection().prepareStatement("delete from Trainee where traineeId=?");

			statement.setInt(1, traineeId);

			statement.executeUpdate();
			System.out.println("Trainee deleted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trainee;

	}

	public Trainee updateTrainee(int traineeId, String traineeName, String traineeEmail) {
		Trainee trainee = new Trainee();
		try {

			PreparedStatement statement = getConnection()
					.prepareStatement("update Trainee set traineeName=?,traineeEmail=? where traineeId=?");

			statement.setString(1, traineeName);
			statement.setString(2, traineeEmail);
			statement.setInt(3, traineeId);

			int a = statement.executeUpdate();
			System.out.println("Trainee updated successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trainee;

	}

	public Trainee getTraineeByid(int id) {
		Trainee trainee = new Trainee();

		try {

			PreparedStatement statement = getConnection().prepareStatement(
					"select t.*,tc.* from trainee t,trainee_course tc where tc.tId=t.traineeId and traineeId=?");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Trainee_Course tc = new Trainee_Course();
				tc.setTcId(result.getInt("tcId"));
				tc.settId(result.getInt("tId"));
				tc.setcId(result.getInt("cId"));
				trainee.setTraineeId(result.getInt("traineeId"));
				trainee.setTraineeName(result.getString("traineeName"));
				trainee.setTraineeEmail(result.getString("traineeEmail"));
				trainee.setListOfTraineeCourse(Arrays.asList(tc));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trainee;
	}

	public Course addCourses(Course course) {

		try {

			int lastRecordInCourseTable = getLastRecordId();
			int newRecordId = lastRecordInCourseTable + 1;
			PreparedStatement statement = getConnection().prepareStatement("insert into Course values(?,?)");

			statement.setInt(1, newRecordId);
			statement.setString(2, course.getCourseName());
			int a = statement.executeUpdate();
			System.out.println("Course added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;

	}

	public List<Trainee> showAllTrainees() {
		List<Trainee> traineeList = new ArrayList<>();

		try {

			Statement statement = getConnection().createStatement();
			ResultSet result = statement.executeQuery("select * from Trainee");
			while (result.next()) {
				Trainee trainee = new Trainee();
				trainee.setTraineeId(result.getInt("traineeId"));
				trainee.setTraineeName(result.getString("traineeName"));
				trainee.setTraineeEmail(result.getString("traineeEmail"));
				traineeList.add(trainee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return traineeList;
	}

	public int updateTraineeCourseById(int tId, int cId, int UcId) {
		int result = 0;
		try {

			PreparedStatement statement = getConnection()
					.prepareStatement("update Trainee_Course set cid=? where tId=?");
			statement.setInt(1, UcId);
			statement.setInt(2, tId);

			result = statement.executeUpdate();
			System.out.println("successfully updated Trainee Courses");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Trainee getTraineeFullDetails(int tId, int cId, int UcId) {

		Trainee a = getTraineeByid(tId);
		System.out.println(a.toString());
		for (Trainee_Course tc : a.getListOfTraineeCourse()) {
			if (tc.getcId() == cId) {
				updateTraineeCourseById(tId, cId, UcId);
			}
		}
		return getTraineeByid(tId);
	}

	private int getLastRecordId() throws SQLException {
		int lastRecordId = 0;

		try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT MAX(courseId) FROM Course");
				ResultSet resultSet = preparedStatement.executeQuery()) {

			if (resultSet.next()) {
				lastRecordId = resultSet.getInt(1);
			}
		}

		return lastRecordId;
	}

	private int getLastRecordOfTaineeId() throws SQLException {
		int lastRecordId = 0;

		try (PreparedStatement preparedStatement = getConnection()
				.prepareStatement("SELECT MAX(traineeId) FROM Trainee");
				ResultSet resultSet = preparedStatement.executeQuery()) {

			if (resultSet.next()) {
				lastRecordId = resultSet.getInt("MAX(traineeId)");
			}
		}

		return lastRecordId;
	}

	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagementSystem",
				"root", "Rakesh@1999");
		return connection;

	}

}
