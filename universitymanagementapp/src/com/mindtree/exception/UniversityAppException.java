package com.mindtree.exception;

public class UniversityAppException extends Exception {

	public UniversityAppException() {
		super();
	}

	public UniversityAppException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UniversityAppException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UniversityAppException(String arg0) {
		super(arg0);
	}

	public UniversityAppException(Throwable arg0) {
		super(arg0);
	}

}
