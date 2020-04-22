package org.niko.mywebapp;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

public class Connection {
	
	public static final String DATABASE_URL = "/Users/jorge/Documents/java/test.db";
	
	ConnectionSource source;
	
	Lorem lorem;
	
	Connection(){
		lorem = LoremIpsum.getInstance();
		String databaseUrl = "jdbc:sqlite:" + DATABASE_URL;
		try {
			this.source = new JdbcConnectionSource(databaseUrl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void populateDatabase(){
		try {
			TableUtils.createTableIfNotExists(this.source, Tweet.class);
			TableUtils.createTableIfNotExists(this.source, Reply.class);
			
			Dao<Tweet, Integer> tweetsDao = DaoManager.createDao(this.source, Tweet.class);
			
			Dao<Reply, Integer> repliesDao = DaoManager.createDao(this.source, Reply.class);
			
			
			for(int i = 0; i < 5; i++) {
				Tweet tweet = new Tweet("Jorge" + i, this.lorem.getWords(5, 10));
				tweetsDao.create(tweet);
				
				Reply replie = new Reply("Dummy" + i, this.lorem.getWords(5, 10), tweet);
				repliesDao.create(replie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
