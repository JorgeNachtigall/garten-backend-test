package org.niko.mywebapp;

import com.j256.ormlite.field.DatabaseField;


public class Replie {

	public static final String ID_FIELD_NAME = "id";
	public static final String AUTHOR_FIELD_NAME = "author";
	public static final String CONTENT_FIELD_NAME = "content";
	public static final String LIKES_FIELD_NAME = "likesSize";
	public static final String RETWEETS_FIELD_NAME = "retweetsSize";
	public static final String REPLIES_FIELD_NAME = "repliesSize";
	public static final String TWEET_FIELD_NAME = "tweet";
	
	@DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
    private int id;
	
	@DatabaseField(canBeNull = false, columnName = AUTHOR_FIELD_NAME)
	private String author;
	
	@DatabaseField(canBeNull = false, columnName = CONTENT_FIELD_NAME)
    private String content;
	
	@DatabaseField(canBeNull = false, columnName = LIKES_FIELD_NAME)
    private int likesNum;
	
	@DatabaseField(canBeNull = false, foreign = true, columnName = TWEET_FIELD_NAME)
	private transient Tweet tweet;
	
	Replie(){}
	
	Replie(String author, String content, Tweet tweet){
		this.author = author;
		this.content = content;
		this.likesNum = 0;
		this.tweet = tweet;
	}
	
	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
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
		
}
