package com.challenge.simpleApp.basic.Auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.simpleApp.Model.AuthBean;


@CrossOrigin(origins= {"http://localhost:4200","http://localhost:8081"})
@RestController
public class BasicAuthController {
	
	@GetMapping(path = "/basicauth")
	public AuthBean helloWorldPath() {
	
		return new AuthBean("Hello world !!");
		}
	
}
