package com.eduted.webservices.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.eduted.webservices.repositories.PostRepository;

public class PostService
{
	@Autowired
	private PostRepository repo = null;
}
