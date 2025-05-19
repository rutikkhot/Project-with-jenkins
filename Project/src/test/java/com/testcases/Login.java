package com.testcases;

import org.testng.annotations.Test;

public class Login {

	@Test
	public void login_with_valid_username () {
		System.out.println("Login Succefully");
	}
	
	@Test
	public void login_with_invalid_username () {
		System.out.println("Incorrect Username");
	}
	
	@Test
	public void login_with_invalid_password () {
		System.out.println("Incorrect Password");
	}
	
	@Test
	public void login_with_mobileno () {
		System.out.println("Login.....");
	}
}
