package com.dmantz.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TraineeTest {
	public static void main(String[] args) throws IOException {
		Trainee t=new Trainee();
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);


		
		System.out.println(t.getListOfTrainee());
	}

}
