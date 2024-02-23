package com.dmantz.SpringJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dmantz.SpringJDBC.model.Alian;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringJdbcApplication.class, args);
		
		Alian alian=context.getBean(Alian.class);
		
		alian.setId(101);
		alian.setName("Rakesh");
		alian.setTech("JAVA");
	}

}
