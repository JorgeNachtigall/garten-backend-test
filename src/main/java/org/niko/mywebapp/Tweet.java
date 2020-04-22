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
	
		
	Tweet(){}
	
	Tweet(String author, String content){
		this.author = author;
		this.content = content;
	}
		
	public String getAuthor() {
		return this.author;
	}
		
	public String getContent() {
		return this.content;
	}		
}
