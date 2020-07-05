package com.eduted.webservices.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
//import com.eduted.webservices.services.ProfileService;
import com.eduted.webservices.services.UserService;

@RestController
@RequestMapping("eduted/users")
public class UserResources
{
	@Autowired
	private UserService userServices = new UserService();

//	@Autowired
//	private ProfileService profileServices = new ProfileService();
	
/*******************************************************************************************/
	
	@PostMapping("user")
	@ResponseBody
	public ResponseEntity<String> createNewUser(@RequestBody User user)
	{
		System.out.println(user);
		
		if(user == null)
			return new ResponseEntity<String> ("No Data Found...[ERROR]", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<String> (userServices.addNewUser(user), HttpStatus.OK);
	}
	

	@GetMapping("user/{id}")
	public ResponseEntity<String> searchUser(@PathVariable("id") String id)
	{
		if(id == null)
			return new ResponseEntity<String> ("No Data Found...[ERROR]", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<String> (userServices.getUserById(id), HttpStatus.OK);
	}

	@GetMapping("user")
	public ResponseEntity<List<User>> searchAllUser()
	{
		return new ResponseEntity<List<User>> (userServices.getAllUsers(), HttpStatus.OK);
	}
	
/*
	@PostMapping("post")
	@ResponseBody
	public ResponseEntity<String> createNewProfile(@RequestBody Profile profile)
	{
		System.out.println(profile);
		
		if(profile == null)
			return new ResponseEntity<String> ("No Data Found...[ERROR]", HttpStatus.NOT_FOUND);
		
//		return new ResponseEntity<String> (userServices.addNewUser(post), HttpStatus.OK);
	}
*/
}
