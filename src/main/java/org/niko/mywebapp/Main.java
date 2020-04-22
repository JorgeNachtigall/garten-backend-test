package org.niko.mywebapp;
import static spark.Spark.*;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = new Connection();
		
		Dao<Tweet, Integer> tweetsDao = DaoManager.createDao(connection.source, Tweet.class);
		Dao<Reply, Integer> repliesDao = DaoManager.createDao(connection.source, Reply.class);
		
		connection.populateDatabase();
		                        
        connection.source.close();
		
		get("/tweets", (req, res) -> {
            res.type("application/json");
            
            List<Tweet> tweets = tweetsDao.queryForAll();

            if(!tweets.isEmpty())
            	return new Gson().toJson(new Response(Status.SUCCESS, new Gson().toJsonTree(tweets)));
            else
            	return new Gson().toJson(new Response(Status.SUCCESS, new Gson().toJsonTree(new Object())));
        });
		
		get("/tweet/:id", (req, res) -> {			
			res.type("application/json");
			
			Tweet tweet = tweetsDao.queryForId(Integer.parseInt(req.params(":id")));
			
			if(tweet != null)
				return new Gson().toJson(new Response(Status.SUCCESS, new Gson().toJsonTree(tweet)));
			else
				return new Gson().toJson(new Response(Status.SUCCESS, new Gson().toJsonTree(new Object())));
		});
		
		get("/tweet/:id/replies", (req, res) -> {
			res.type("application/json");
						
			Tweet tweet = tweetsDao.queryForId(Integer.parseInt(req.params(":id")));
			
			if(tweet != null) {
				List<Reply> replies = repliesDao.queryForEq(Reply.TWEET_FIELD_NAME, tweet);
				if(!replies.isEmpty())
					return new Gson().toJson(new Response(Status.SUCCESS, new Gson().toJsonTree(replies)));
				else
					return new Gson().toJson(new Response(Status.SUCCESS, new Gson().toJsonTree(new Object())));
			}
			else
				return new Gson().toJson(new Response(Status.SUCCESS, new Gson().toJsonTree(new Object())));
		});
		
		post("/tweet", (req, res) ->{
			res.type("application/json");
			
			Tweet tweet = new Gson().fromJson(req.body(), Tweet.class);
			
			if(tweetsDao.create(tweet) == 1)
				return new Gson().toJson(new Response(Status.SUCCESS, "Tweet created with success"));
			else
				return new Gson().toJson(new Response(Status.ERROR, "Can't create the requested tweet"));
		});
		
		post("/tweet/:id/reply", (req, res) ->{
			res.type("application/json");
			
			Reply reply = new Gson().fromJson(req.body(), Reply.class);
			
			Tweet tweet = tweetsDao.queryForId(Integer.parseInt(req.params(":id")));
			
			reply.setTweet(tweet);
			
			if(repliesDao.create(reply) == 1)
				return new Gson().toJson(new Response(Status.SUCCESS, "Reply created with success"));
			else
				return new Gson().toJson(new Response(Status.ERROR, "Can't create the requested reply"));
		});
    }
}
