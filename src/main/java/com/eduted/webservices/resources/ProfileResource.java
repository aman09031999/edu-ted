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

import com.eduted.webservices.model.Profile;
import com.eduted.webservices.services.ProfileService;

@RestController
@RequestMapping("eduted/profiles")
public class ProfileResource
{
	@Autowired
	private ProfileService profileServices = new ProfileService();
	
	@PostMapping("user/{userId}/profile")
	@ResponseBody
	public ResponseEntity<String> createNewProfile(@PathVariable("userId") String id, @RequestBody Profile profile)
	{
		System.out.println(profile);
		
		if(profile == null)
			return new ResponseEntity<String> ("No Data Found...[ERROR]", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<String> (profileServices.addNewProfile(id, profile), HttpStatus.OK);
	}
	
	@GetMapping("profile/{profileId}")
	public ResponseEntity<Profile> searchProfile(@PathVariable("profileId") String profileId)
	{
		if(profileId == null)
			return new ResponseEntity<Profile> (new Profile(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Profile> (profileServices.getProfileById(profileId), HttpStatus.OK);
	}
	
	@GetMapping("user/{userId}/profile/{profileId}")
	public ResponseEntity<Profile> searchProfile(@PathVariable("userId") String userId, @PathVariable("profileId") String profileId)
	{
		if(userId == null || profileId == null)
			return new ResponseEntity<Profile> (new Profile(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Profile> (profileServices.getProfileById(userId, profileId), HttpStatus.OK);
	}
/*
	@GetMapping("profile/{id}")
	public ResponseEntity<String> searchProfile(@PathVariable("id") String id)
	{
		if(id == null)
			return new ResponseEntity<String> ("No Data Found...[ERROR]", HttpStatus.NOT_FOUND);

		return new ResponseEntity<String> (profileServices.getProfileById(id), HttpStatus.OK);
	}
*/

	@GetMapping("profile")
	public ResponseEntity<List<Profile>> searchAllProfile()
	{
		return new ResponseEntity<List<Profile>> (profileServices.getAllProfiles(), HttpStatus.OK);
	}
}
