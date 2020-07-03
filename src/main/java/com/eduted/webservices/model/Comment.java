package com.eduted.webservices.model;

import java.util.Date;
import java.util.List;

public class Comment
{
	private String commentId;
	
	private Post post;
	private Profile profile;	
	private int likesCount;
	private List<Reply> replyList;
	private Date date_time;
}
