package com.eduted.webservices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduted.webservices.model.Profile;
import com.eduted.webservices.repositories.ProfileRepository;
import com.eduted.webservices.repositories.UserRepository;

@Service
public class ProfileService
{
	@Autowired
	private ProfileRepository repo = null;
	
	@Autowired
	private UserRepository userRepo = null;
	
	public String addNewProfile(String userId, Profile profile)
	{		
		if(userRepo.existsById(userId))
		{
			System.out.println("user with ID : " + userId + ", exists...[OK]");

			userRepo.save(userRepo.getOne(userId).setProfile(profile));			
			System.out.println("user with ID : " + userId + ", updated...[OK]");
			
			repo.save(profile);
			System.out.println("Profile with ID : " + profile.getProfileId() + ", created and updated...[OK]");
			
			return "profile with ID : " + profile.getProfileId() + ", added successfully...[OK]";
		}
		else
			return "user with ID : " + userId + ", doesn't exists...[FAILED]";
	}
	
	public Profile getProfileById(String id)
	{
		if(repo.existsById(id))
			return repo.getOne(id);		//.toString();
		else
			return new Profile();		//"profile with ID : " + id + ", doesn't exists...[FAILED]";
	}
	
	public Profile getProfileById(String userId, String profileId)
	{
		if(userRepo.existsById(userId))
		{
			if(repo.existsById(profileId))
				return repo.getOne(profileId);		//.toString();
			else
				return new Profile();		//"profile with ID : " + id + ", doesn't exists...[FAILED]";
		}
		
		return new Profile();
	}
	
	public List<Profile> getAllProfiles()
	{
		if(repo.findAll() != null)
			return repo.findAll();

		return new ArrayList<>();
	}
}
