package com.pvkr.java8.util;

public class UserCheck {
	public boolean isUserReal(User user) {
		return user.getUserName().length() == 5;
	}
}
