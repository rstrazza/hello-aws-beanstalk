package com.stz.aws.beanstalk.web;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author rbortoloto
 * 
 */
@Document(collection = "users")
public class User {

	@Id
	private String id;
	private String userName;

	public User(String userName) {
		this.userName = userName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "id: [" + getId() + "] - user name: [" + getUserName() + "]"
				+ System.getProperty("line.separator");
	}

}
