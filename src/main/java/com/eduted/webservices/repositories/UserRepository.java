package com.eduted.webservices.repositories;

import java.util.ArrayList;
import java.util.List;

import com.eduted.webservices.model.User;

public class UserRepository
{
	List<User> users = new ArrayList<>();

	public List<User> getUsers() 		{	return users;			}
	public void addUsers(User users)	{	this.users.add(users);	}
	
}
