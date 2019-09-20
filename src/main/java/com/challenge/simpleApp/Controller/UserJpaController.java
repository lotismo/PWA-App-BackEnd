package com.challenge.simpleApp.Controller;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.challenge.simpleApp.Model.User;

@CrossOrigin(origins= {"http://localhost:4200","http://localhost:8081"})
@RestController
public class UserJpaController {
	
	@Autowired
	private HardcodedUserService userService;
	
	@Autowired
	private UserJpaRepository userJpaRepo;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userJpaRepo.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id){
		return userJpaRepo.findById(id).get();
	}
	
	@GetMapping("/userN/{name}")
	public User getUserbyName(@PathVariable String name){
		return userService.findUserbyName(name);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id){
		userJpaRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user){
		User newUser = userJpaRepo.save(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<Void> createUser(@RequestBody User user){
//		System.out.println("creating :" +"| user : "+ user);
		User newUser = userJpaRepo.save(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping("/user/{id}")
	public String updateUserImage( @PathVariable int id, @RequestParam("image") MultipartFile image, HttpServletRequest req) {
		
		System.out.println("Updating image url : "+ image.getOriginalFilename());
		String imageName = image.getOriginalFilename().replaceAll(" ", "-");
		
		Path filepath = Paths.get("");
		filepath = Paths.get(filepath.toAbsolutePath().toString(),"/src/main/resources/static/user-images/" + imageName);
		String url = filepath.toString();
		String avatarUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() +"/user-images/"+imageName;
	    try {
			image.transferTo(filepath);
			User userTmp = userJpaRepo.findById(id).get();
			userTmp.setAvatar(filepath.toString());
			userJpaRepo.save(userTmp);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failed";
		}
	    System.out.println(avatarUrl);
		return "succeded";
	}
	
	
	
	
	
	
}
