package com.mindtree.exception.serviceexception;

import com.mindtree.exception.UniversityAppException;

public class UniversityAppServiceException extends UniversityAppException {

	public UniversityAppServiceException() {
		super();
	}

	public UniversityAppServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UniversityAppServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UniversityAppServiceException(String arg0) {
		super(arg0);
	}

	public UniversityAppServiceException(Throwable arg0) {
		super(arg0);
	}

}
