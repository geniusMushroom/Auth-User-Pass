package com.iSoftware.Exception.Invalidaton;

public class InvalidUserNameException extends Exception {

	@Override
	public String getMessage() {
		return "Invalid UserName";
	}

}
