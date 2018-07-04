package com.pvkr.java8.util;

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

	public boolean isUserReal() {
		return this.getUserName().length() == 7;
	}

	public void printUser() {

	}
}
