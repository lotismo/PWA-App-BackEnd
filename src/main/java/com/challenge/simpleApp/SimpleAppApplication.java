package com.challenge.simpleApp;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleAppApplication.class, args);
		 File newFolder = new File(System.getProperty("user.home")+"\\Challenge");
         
	        boolean created =  newFolder.mkdir();
	         
//	        if(created)
//	            System.out.println("Folder was created !");
//	        else
//	            System.out.println("Unable to create folder");
	}

}
