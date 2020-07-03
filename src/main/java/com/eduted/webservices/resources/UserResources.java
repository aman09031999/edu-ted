package com.eduted.webservices.resources;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduted.webservices.model.User;
import com.eduted.webservices.services.UserService;

@RestController
@RequestMapping("eduted/users")
public class UserResources
{
	UserService userServices = new UserService();
	
	@PostMapping("user")
	@ResponseBody
	public ResponseEntity<User> addNewUser(@RequestBody User user)
	{
		System.out.println(user);
		
		if(user == null)
			return new ResponseEntity<User> (new User(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User> (userServices.addNewUser(user), HttpStatus.OK);
	}
	

	@GetMapping("user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") String id)
	{
		if(id == null)
			return new ResponseEntity<User> (new User(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User> (userServices.findUserById(id), HttpStatus.OK);
	}

	@GetMapping("user")
	public ResponseEntity<List<User>> getAllUser()
	{
		return new ResponseEntity<List<User>> (userServices.getAllUsers(), HttpStatus.OK);
	}
}
