package com.eduted.webservices.model;

import java.util.List;

public class Profile
{
	private String profileId;
	
	private String userName;
	private String profilePic;
	private User user;
	private boolean accountActive;


	private boolean blueTick;
	private String bio;
	private int followingCount;
	private int followerCount;
	private int postCount;


	private List<Post> favouritePostList;
	private List<User> followersList;
	private List<Post> postList;
	private List<User> followingList;
	private List<User> BlockedUserList;
	
	private int reportCount;
	
//	private List<indox> share.url;	
//	private =#PhotoUserNametag
}
