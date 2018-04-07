package com.iSoftware.Exception.Invalidaton;

public class CustomeExceptionTest {

	public static void main(String[] args) {
		String userName = "swamy";
		String password = "Swamy@123";
		boolean isAuthenticated = false;
		try {
			isAuthenticated = isAuthenticated(userName, password);
		} catch (InvalidUserNameException e) {
			System.err.println("Invalid user login details:" + e.getMessage());
		}
		catch (InvalidPasswordException e) {
			System.err.println("Invalid Password  details:" + e.getMessage());
		}
		if (isAuthenticated) {
			System.out.println("Welcome");
		} else {
			System.err.println("Invalid credentias");
		}

	}

	public static boolean isAuthenticated(String userName, String password) throws InvalidUserNameException, InvalidPasswordException {

		if (userName.length() < 5) {
			throw new InvalidUserNameException();
		}
		boolean valid = true;
		if (password.length() > 15 || password.length() < 8) {
			System.out.println("Password should be less than 15 and more than 8 characters in length.");
			valid = false;
		}

		String upperCaseChars = "(.*[A-Z].*)";
		if (!password.matches(upperCaseChars)) {
			System.out.println("Password should contain atleast one upper case alphabet");
			valid = false;
		}
		String lowerCaseChars = "(.*[a-z].*)";
		if (!password.matches(lowerCaseChars)) {
			System.out.println("Password should contain atleast one lower case alphabet");
			valid = false;
		}
		String numbers = "(.*[0-9].*)";
		if (!password.matches(numbers)) {
			System.out.println("Password should contain atleast one number.");
			valid = false;
		}
		String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
		if (!password.matches(specialChars)) {
			System.out.println("Password should contain atleast one special character");
			valid = false;
		}
		if (valid) {
			System.out.println("Password is valid.");
		} else {
			System.out.println("Password is weak and invalid for login credentials");
			throw new InvalidPasswordException();
		}

		// DB logic
		if (userName.equals("swamy") && password.equals("Swamy@123")) {
			return true;
		}

		return false;

	}

}
