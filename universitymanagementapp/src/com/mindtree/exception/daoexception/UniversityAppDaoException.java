package com.mindtree.exception.daoexception;

import com.mindtree.exception.UniversityAppException;

public class UniversityAppDaoException extends UniversityAppException {

	public UniversityAppDaoException() {
		super();
	}

	public UniversityAppDaoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UniversityAppDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UniversityAppDaoException(String arg0) {
		super(arg0);
	}

	public UniversityAppDaoException(Throwable arg0) {
		super(arg0);
	}

}
