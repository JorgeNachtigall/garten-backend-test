package org.niko.mywebapp;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class generateDatabase {

	generateDatabase(ConnectionSource source){
		
		try {
			TableUtils.createTableIfNotExists(source, Tweet.class);
			TableUtils.createTableIfNotExists(source, Replie.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void populate(ConnectionSource source) {
		
		try {
			Dao<Tweet, Integer> tweetsDao = DaoManager.createDao(source, Tweet.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < 5; i++) {
		}
		
	}
	
}
