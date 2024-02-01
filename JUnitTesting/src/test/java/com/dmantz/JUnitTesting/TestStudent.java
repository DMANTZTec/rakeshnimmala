package com.dmantz.JUnitTesting;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestStudent {
	
	
	@Test
	public void testStudent() {
		List<Student> actual=Arrays.asList(
	            new Student(2,"vamshi"),
	            new Student(3,"ganesh"));
		List<Student> Expected=Arrays.asList(
	            new Student(2,"vamshi"),
	            new Student(3,"ganesh"));
		//System.out.println(list.);
		Assert.assertEquals(actual.size(),2);
		Assert.assertEquals(false, (actual.isEmpty()));
		Assert.assertEquals(true,actual!=Expected);		
	}

}
