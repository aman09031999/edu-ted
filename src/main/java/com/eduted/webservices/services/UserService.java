package com.eduted.webservices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduted.webservices.model.User;
import com.eduted.webservices.repositories.UserRepository;

@Service
public class UserService
{
	@Autowired
	private UserRepository repo = null;
		
	public String addNewUser(User user)
	{
		if(repo.existsById(user.getUserId()))
			return "user already exists...[FAILED]";
		else
		{
			repo.save(user);
			return "user with ID : "+user.getUserId()+", added successfully...[OK]";
		}
	}

	public String getUserById(String id)
	{
		if(id != null)
		{
			if(repo.existsById(id))
				return repo.findById(id).toString();
			else
				return "user with ID "+id+", doesn't exists";
		}
		
		return "ERROR";
		
	}
	
	public List<User> getAllUsers()
	{
		if(repo.findAll() != null)
			return repo.findAll();
		else
			return new ArrayList<>();
	}
}
