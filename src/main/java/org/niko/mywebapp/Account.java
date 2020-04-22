package org.niko.mywebapp;

import com.j256.ormlite.field.DatabaseField;

public class Account {
	
    @DatabaseField(id = true)
    private String name;

    @DatabaseField(canBeNull = true)
    private String password;
    
    Account() {

    }

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
