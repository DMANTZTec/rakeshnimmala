package com.dmantz.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Demo {
	public static void readFile(String filePath) throws IOException {
			FileWriter mywriter = new FileWriter("C:\\FilesProgram\\WriteFile.txt");

		try {
			File myfile=new File(filePath);

			Scanner	sc = new Scanner(myfile);
			//Scanner	sc1 = new Scanner(System.in);

			 List<String> list=new ArrayList<>();

		
		 while(sc.hasNextLine()) {
			 String data=sc.nextLine();
		   //  String line = data.nextLine();
             String[] details = data.split(",");
           
             list=Arrays.asList(details);

				System.out.println("successfully wrote in file");
           for(String k:list) {
             
//             list.add(k);
//		//	System.out.println("write dta....");
        	   
               mywriter.write(k+","+ System. lineSeparator());
             //  mywriter.write(",");


//
				
             }
           
			mywriter.close();

		 }
		// System.out.println(list);
		 sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[]args) throws IOException {
		String filePath="C:\\FilesProgram\\Myfile.txt";
		readFile(filePath);
	}

}
