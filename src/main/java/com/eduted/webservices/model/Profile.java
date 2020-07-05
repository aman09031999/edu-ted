package com.eduted.webservices.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="profile_table")
public class Profile implements Serializable
{
	private static final long serialVersionUID = -1618124011279136680L;

	@Id
	private String profileId;
	
	private String profileName;
	private String profilePic;

	private boolean accountActive;
	private boolean blueTick;
	private String bio;
	private int followingCount;
	private int followerCount;
	private int postCount;


	@OneToMany(mappedBy="profile", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Post> postList;
	
	@Transient
	private List<Post> favouritePostList;
	@Transient
	private List<User> followersList;
	@Transient
	private List<User> followingList;
	@Transient
	private List<User> BlockedUserList;
	
	private int reportCount;


	public Profile()	{	}
	
	public Profile(String profileId, String profileName, String profilePic, boolean accountActive, boolean blueTick,
			String bio, int followingCount, int followerCount, int postCount, List<Post> favouritePostList,
			List<User> followersList, List<Post> postList, List<User> followingList, List<User> blockedUserList,
			int reportCount) {
		this.profileId = profileId;
		this.profileName = profileName;
		this.profilePic = profilePic;
		this.accountActive = accountActive;
		this.blueTick = blueTick;
		this.bio = bio;
		this.followingCount = followingCount;
		this.followerCount = followerCount;
		this.postCount = postCount;
		this.favouritePostList = favouritePostList;
		this.followersList = followersList;
		this.postList = postList;
		this.followingList = followingList;
		this.BlockedUserList = blockedUserList;
		this.reportCount = reportCount;
	}
	
	
	public String getProfileId() 				{	return profileId;			}
	public String getprofileName() 				{	return profileName;			}
	public String getProfilePic() 				{	return profilePic;			}
	public boolean isAccountActive()			{	return accountActive;		}
	public boolean isBlueTick() 				{	return blueTick;			}
	public String getBio() 						{	return bio;					}
	public int getFollowingCount() 				{	return followingCount;		}
	public int getFollowerCount() 				{	return followerCount;		}
	public int getPostCount() 					{	return postCount;			}
	public List<Post> getFavouritePostList()	{	return favouritePostList;	}
	public List<User> getFollowersList() 		{	return followersList;		}
	public List<Post> getPostList() 			{	return postList;			}
	public List<User> getFollowingList() 		{	return followingList;		}
	public List<User> getBlockedUserList() 		{	return BlockedUserList;		}
	public int getReportCount() 				{	return reportCount;			}
	
	
	public Profile setProfileId(String profileId)						{	this.profileId = profileId;					return this;	}
	public Profile setprofileName(String profileName)					{	this.profileName = profileName;				return this;	}
	public Profile setProfilePic(String profilePic) 					{	this.profilePic = profilePic;				return this;	}
	public Profile setAccountActive(boolean accountActive) 				{	this.accountActive = accountActive;			return this;	}
	public Profile setBlueTick(boolean blueTick) 						{	this.blueTick = blueTick;					return this;	}
	public Profile setBio(String bio) 									{	this.bio = bio;								return this;	}
	public Profile setFollowingCount(int followingCount) 				{	this.followingCount = followingCount;		return this;	}
	public Profile setFollowerCount(int followerCount) 					{	this.followerCount = followerCount;			return this;	}
	public Profile setPostCount(int postCount) 							{	this.postCount = postCount;					return this;	}
	public Profile setFavouritePostList(List<Post> favouritePostList)	{	this.favouritePostList = favouritePostList;	return this;	}
	public Profile setFollowersList(List<User> followersList) 			{	this.followersList = followersList;			return this;	}
	public Profile setPostList(List<Post> postList) 					{	this.postList = postList;					return this;	}
	public Profile setFollowingList(List<User> followingList) 			{	this.followingList = followingList;			return this;	}
	public Profile setBlockedUserList(List<User> blockedUserList)		{	this.BlockedUserList = blockedUserList;		return this;	}
	public Profile setReportCount(int reportCount) 						{	this.reportCount = reportCount;				return this;	}
	
	
}
