package com.challenge.simpleApp.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.simpleApp.Model.User;

@Service
public class HardcodedUserService {
	
	private static List<User> users = new ArrayList<>();
	private static int idcounter = 0;
	
	static {
		users.add(new User(++idcounter,"salah","salah@ss.com",""));
		users.add(new User(++idcounter,"jack","jack@ss.com",""));
		users.add(new User(++idcounter,"said","said@ss.com",""));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findUser(int id) {
		//return users.get(id - 1);
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User findUserbyName(String name) {
		//return users.get(id - 1);
		for(User user : users) {
			if(user.getName().equals(name)) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteUser(int id) {
		User user = findUser(id);
		
		if(user==null) return null;
		if(users.remove(id - 1) != null){
			return user;
		}
		return null;
	}
	
	public User save(User user) {
		if(user.getId() == -1 || user.getId() == 0) {
			user.setId(++idcounter);
			users.add(user);
		}
		else {
			for(User userIterator : users) {
				if(user.getId() == userIterator.getId()) {
					userIterator.setName(user.getName());
					userIterator.setEmail(user.getEmail());
					userIterator.setPassword(user.getPassword());
					userIterator.setAvatar(user.getAvatar());
					break;
				}
			}
//			deleteUser(user.getId());
//			users.add(user);
		}
		return user;
	}
	
	
	public boolean modifyUserImage(int userId, String imgPath) {
		
			for(User userIterator : users) {
				if(userIterator.getId() == userId) {
					userIterator.setAvatar(imgPath);
					return true;
				}
			}
		return false;
	}
}
