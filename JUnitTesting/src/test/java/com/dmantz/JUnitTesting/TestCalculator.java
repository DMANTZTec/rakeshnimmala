package com.dmantz.JUnitTesting;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TestCalculator {
	
	Calculator c=new Calculator();
	
	
	@Test
	public void testAdd() {
	int z=	c.add(10, 20);
	
	assertEquals(30, z);
		
	}

}
