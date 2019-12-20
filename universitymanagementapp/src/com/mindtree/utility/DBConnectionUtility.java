package com.mindtree.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.exception.daoexception.UniversityAppDaoException;

public class DBConnectionUtility {

	private final String URL = "jdbc:mysql://localhost:3306/universityapp";
	private final String USER_NAME = "root";
	private final String PASSWORD = "Welcome123";

	public Connection getConnection() throws UniversityAppDaoException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {

			throw new UniversityAppDaoException("Connection error. ");
		}
		return con;
	}

	public void closefunnction(Connection con) throws UniversityAppDaoException {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				throw new UniversityAppDaoException(e.getMessage(),e);
			}
	}

	public void closefunnction(Statement st) throws UniversityAppDaoException {
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
				throw new UniversityAppDaoException("close Statement error. ");
			}
	}

	public void closefunnction(ResultSet rs) throws UniversityAppDaoException {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				throw new UniversityAppDaoException("close ResultSet error. ");
			}
	}
}
