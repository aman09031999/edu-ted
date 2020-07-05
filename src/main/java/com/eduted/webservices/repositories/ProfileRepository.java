package com.eduted.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.eduted.webservices.model.Profile;

@EnableJpaRepositories
public interface ProfileRepository extends JpaRepository<Profile, String>
{
	
}
