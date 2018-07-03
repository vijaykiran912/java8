package com.pvkr.java8.method_references;

import lombok.Data;

@Data
public class User {

	private String userName;

	public User() {

	}

	public User(String userName) {
		this.userName = userName;
	}

	public static boolean isRealUser(String userName) {
		return userName.length() == 7;
	}

	public boolean isUserReal(String userName) {
		return userName.length() == 7;
	}

	public boolean isUserReal(User user) {
		return user.getUserName().length() == 7;
	}
}
