package com.eduted.webservices.model;

import java.util.Date;
import java.util.List;

public class Post
{
	private String postId;					//	ID of Post
	private Profile profile;				//	Profile who created the Post
	
	private String video;					//	Content to be shared : Video
	private int likesCount;					//	No. of Likes in the Content(Video)
	private int commentCount;				//	No. of Comments in the Content(Video)
	private int shareCount;					//	No. of Shares in the Content(Video)
	private int viewCount;					//	No. of Views in the Content(Video)
	
	private List<Tags> tags;				//	List of Tags in the Content(Video)
	private List<Comment> commentList;		//	List of Comments in the Content(Video)
	
	private int reportCount;				//	No. of Reports in the Content(Video)
	
	private Date date_time;					//	Date & Time of Content(Video) Posted
}
