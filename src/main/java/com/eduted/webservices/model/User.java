package com.eduted.webservices.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="user_table")
public class User implements Serializable
{
	private static final long serialVersionUID = -531927225204328676L;

	@Id
	private String userId;
	
	private String name;
	private String email;
	private String password;
	
	@OneToOne(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
	@JoinColumn(name="profile_id")
	private Profile profile;
	
	public User()	{	}
	
	public User(String userId, String name, String email, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
	}


	public User setUserId(String userId)		{	this.userId = userId;		return this;	}
	public User setName(String name) 			{	this.name = name;			return this;	}
	public User setEmail(String email) 			{	this.email = email;			return this;	}
	public User setPassword(String password) 	{	this.password = password;	return this;	}
	public User setProfile(Profile profile) 	{	this.profile = profile;		return this;	}
	

	public String getUserId() 	{	return userId;		}
	public String getName() 	{	return name;		}
	public String getEmail() 	{	return email;		}
	public String getPassword() {	return password;	}
	public Profile getProfile() {	return profile;		}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}	
}