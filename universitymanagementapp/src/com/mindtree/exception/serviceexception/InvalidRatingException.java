package com.mindtree.exception.serviceexception;

public class InvalidRatingException extends UniversityAppServiceException {

	public InvalidRatingException() {
		super();
	}

	public InvalidRatingException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public InvalidRatingException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidRatingException(String arg0) {
		super(arg0);
	}

	public InvalidRatingException(Throwable arg0) {
		super(arg0);
	}

	
}
