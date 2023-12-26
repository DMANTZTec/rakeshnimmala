package com.dmantz.employeemanagementsystem.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Course {
	private int courseId;
	private String courseName;
	private ArrayList<Module> listOfModules;

	public ArrayList<Module> getListOfModules() {
		return listOfModules;
	}

	public void setListOfModules(ArrayList<Module> listOfModules) {
		this.listOfModules = listOfModules;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", listOfModules=" + listOfModules + "]";
	}

	public Course getCourseDetailsById(int courseId) throws Exception {

		Course course = new Course();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagementSystem",
				"root", "Rakesh@1999");
		PreparedStatement statement = connection
				.prepareStatement("select * from course c   inner join module m on c.courseId=m.courseId"
						+ " inner join topic t on m.moduleId= t.moduleId   where c.courseId=? ");
		statement.setInt(1, courseId);

		ResultSet rst = statement.executeQuery();

		listOfModules = new ArrayList<>();
		while (rst.next()) {

			course.setCourseId(rst.getInt("courseId"));
			course.setCourseName(rst.getString("courseName"));

			System.out.println("courseId: " + course.getCourseId());
			System.out.println("courseName: " + course.getCourseName());

			Module module = new Module();
			module.setModuleId(rst.getInt("moduleId"));
			module.setModuleName(rst.getString("moduleName"));

			Topic topic = new Topic();
			topic.setTopicId(rst.getInt("topicId"));
			topic.setTopicName(rst.getString("topicName"));

			module.setListOfTopics(List.of(topic));

			listOfModules.add(module);

		}

		for (Module module : listOfModules) {
			System.out.println("moduleId :" + module.getModuleId());
			System.out.println("moduleNmae :" + module.getModuleName());

			List<Topic> topics = module.getListOfTopics();
			for (Topic topic : topics) {
				System.out.println("TopicId: " + topic.getTopicId());
				System.out.println("TopicName: " + topic.getTopicName());
			}

			System.out.println();

		}
		return course;

	}
}
