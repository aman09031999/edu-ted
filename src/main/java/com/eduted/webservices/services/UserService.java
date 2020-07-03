package com.eduted.webservices.services;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduted.webservices.model.User;
import com.eduted.webservices.repositories.UserRepository;

@Service
public class UserService
{
	UserRepository repo = new UserRepository();
	
	public User addNewUser(User user)
	{
		if(repo.getUsers().size() == 0)
		{
			repo.addUsers(user);
			return repo.getUsers().get(repo.getUsers().size()-1);
		}

		for(User list : repo.getUsers())
		{
			if(list.getUserId().equals(user.getUserId()))
				return new User();
			else
			{
				repo.addUsers(user);
				return repo.getUsers().get(repo.getUsers().size()-1);
			}
		}
		
		return new User();
	}

	public User findUserById(String id)
	{
		for(User obj : repo.getUsers())
		{
			if(obj.getUserId().equals(id))
			{
				return obj;
			}
			else
				return new User();
		}
		
		return new User();
	}
	
	public List<User> getAllUsers()
	{
		if(repo.getUsers() != null)
			return repo.getUsers();
		else
			return new ArrayList<>();
	}
}
