package com.eduted.webservices.model;

public class User 
{
	private String userId;
	
	private String name;
	private String email;
	private String password;
	
	public User setUserId(String userId)		{	this.userId = userId;		return this;	}
	public User setName(String name) 			{	this.name = name;			return this;	}
	public User setEmail(String email) 			{	this.email = email;			return this;	}
	public User setPassword(String password) 	{	this.password = password;	return this;	}


	public String getUserId() 	{	return userId;		}
	public String getName() 	{	return name;		}
	public String getEmail() 	{	return email;		}
	public String getPassword() {	return password;	}
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}	
}