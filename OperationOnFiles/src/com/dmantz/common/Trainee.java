package com.dmantz.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Trainee {
	private int traineeId;
	private String traineeName;
	private double salary;

	public int getTaineeId() {
		return traineeId;
	}

	public void setTaineeId(int taineeId) {
		this.traineeId = taineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName=" + traineeName + ", salary=" + salary + "]";
	}

	public List<Trainee> getListOfTrainee() throws IOException {

		String filePath = "C:\\FilesProgram\\Myfile.txt";
		FileWriter mywriter = new FileWriter("C:\\FilesProgram\\WriteFile.txt");
		List<Trainee> list = new ArrayList<>();
		List<String> list1 = new ArrayList<>();

		try {
			File myfile = new File(filePath);

			Scanner sc = new Scanner(myfile);

			while (sc.hasNextLine()) {
				String data = sc.nextLine();
				String[] details = data.split(",");

				list1 = Arrays.asList(details);
			}

			for (String i : list1) {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Rakesh@1999");
				PreparedStatement pstm = con.prepareStatement("select * from trainees where traineeId=?");
				pstm.setString(1, i);
				ResultSet result = pstm.executeQuery();
				while (result.next()) {
					Trainee t = new Trainee();
					t.setTaineeId(result.getInt("traineeId"));
					t.setTraineeName(result.getString("traineeName"));
					t.setSalary(result.getDouble("salary"));
					list.add(t);
				}
				for (Trainee k : list) {

					mywriter.write(k + ",");

				}

				

			}
			mywriter.close();
		}
		

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
}
