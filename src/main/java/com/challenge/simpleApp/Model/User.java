package com.challenge.simpleApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seq", initialValue=10, allocationSize=100)
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private Integer id;
	
	private String name;
	private String password;
	private String email;
	private String avatar;
	
	public User() {
		super();
		this.id = 0;
		this.name = "";
		this.email = "";
		this.avatar = "";
	}
	
	public User(int id, String name, String email,String avatar) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.avatar = avatar;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String mail) {
		this.email = mail;
	}
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", avatarLink=" + avatar + "]";
	}
	
	

}
