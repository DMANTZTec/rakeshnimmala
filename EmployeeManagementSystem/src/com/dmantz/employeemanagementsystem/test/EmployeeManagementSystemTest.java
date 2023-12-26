package com.dmantz.employeemanagementsystem.test;

import com.dmantz.employeemanagementsystem.common.Course;
import com.dmantz.employeemanagementsystem.common.Mentor;
import com.dmantz.employeemanagementsystem.common.Trainee;

public class EmployeeManagementSystemTest {
	public static void main(String[] args) throws Exception {
		Trainee trainee = new Trainee();
		trainee.setTraineeId(6);
		trainee.setTraineeName("Anupama");
		trainee.setTraineeEmail("anupama@gmail.com");
		// trainee.assignedCourses(1);
		// trainee.traineeDetails(1);

		// trainee.traineeDetails(trainee);
		// trainee.assignedCourses(trainee);
		// trainee.allCourses();

		Course course = new Course();
		course.setCourseId(2);
		course.setCourseName("ReactJS");
//		course.getCourseDetailsById(course);
//		
		Mentor mentor = new Mentor();
		//System.out.println(mentor.showAllTrainees().get(0).getTraineeName());
		// System.out.println(mentor.getTraineeByid(1));

		// System.out.println( mentor.getTraineeFullDetails(2, 2, 1));

		//mentor.addtrainee(trainee);
		// mentor.updateTrainee(1,"Rakesh Goud","rakeshgoud@gmail.com");
		// mentor.deleteTrainee(trainee);
		System.out.println( mentor.showAllTrainees());
		// mentor.addCourses(course);
		// mentor.updateTraineeCourseById( 1,1,4);

		// trainee.allCourses(course);

	}
}
