package org.niko.mywebapp;

import com.j256.ormlite.field.DatabaseField;

public class Tweet {
	
	public static final String ID_FIELD_NAME = "id";
	public static final String AUTHOR_FIELD_NAME = "author";
	public static final String CONTENT_FIELD_NAME = "content";
	public static final String LIKES_FIELD_NAME = "likesSize";
	public static final String RETWEETS_FIELD_NAME = "retweetsSize";
	public static final String REPLIES_FIELD_NAME = "repliesSize";
	
	@DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
    private int id;
	
	@DatabaseField(canBeNull = false, columnName = AUTHOR_FIELD_NAME)
	private String author;
	
	@DatabaseField(canBeNull = false, columnName = CONTENT_FIELD_NAME)
    private String content;
	
	@DatabaseField(canBeNull = false, columnName = LIKES_FIELD_NAME)
    private int likesNum;
	
	@DatabaseField(canBeNull = false, columnName = RETWEETS_FIELD_NAME)
    private int retweetsNum;
	
	@DatabaseField(canBeNull = false, columnName = REPLIES_FIELD_NAME)
    private int repliesNum;
		
	Tweet(){}
	
	Tweet(String author, String content){
		this.author = author;
		this.content = content;
		this.likesNum = 0;
		this.retweetsNum = 0;
		this.repliesNum = 0;
	}
		
	public String getAuthor() {
		return this.author;
	}
		
	public String getContent() {
		return this.content;
	}
	
	public Integer getLikesSize() {
		return this.likesNum;
	}
	
	public void incrementLike() {
		this.likesNum += 1;
	}
	
	public Integer getRetweetsSize() {
		return this.retweetsNum;
	}
	
	public void incrementRetweets() {
		this.retweetsNum += 1;
	}
	
	public Integer getRepliesSize() {
		return this.repliesNum;
	}
	
	public void incrementReplies() {
		this.repliesNum += 1;
	}
		
}
