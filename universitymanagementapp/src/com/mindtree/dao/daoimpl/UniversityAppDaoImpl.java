package com.mindtree.dao.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mindtree.dao.UniversityAppDao;
import com.mindtree.entity.College;
import com.mindtree.entity.University;
import com.mindtree.entity.UniversityDetails;
import com.mindtree.exception.daoexception.UniversityAppDaoException;
import com.mindtree.utility.DBConnectionUtility;

public class UniversityAppDaoImpl implements UniversityAppDao {

	DBConnectionUtility connectionutil = new DBConnectionUtility(); //connectionUtil

	@Override
	public boolean registerUniversityToDB(int universityId, String universityName) throws UniversityAppDaoException {
		boolean isInserted = false;
		Connection connection = connectionutil.getConnection();
		PreparedStatement st = null;
		String query = " insert into university values(?,?);";
		try {

			st = connection.prepareStatement(query);
			st.setInt(1, universityId);
			st.setString(2, universityName);
			int count = st.executeUpdate();

			if (count > 0) {
				isInserted = true;
			}

		} catch (SQLException e) {
			throw new UniversityAppDaoException("Duplicate university id entered.");
		} finally {
			connectionutil.closefunnction(st);
			connectionutil.closefunnction(connection);
		}
		return isInserted;
	}

	@Override
	public Set<University> detailsUniversityFromDB() throws UniversityAppDaoException {
		Set<University> uSet = new HashSet<University>();
		Connection connection = connectionutil.getConnection();
		PreparedStatement preparedstmt = null;
		ResultSet resultset = null;
		String query = " select u_id,u_name from university;";
		try {

			preparedstmt = connection.prepareStatement(query);

			resultset = preparedstmt.executeQuery();
			while (resultset.next()) {
				int id = resultset.getInt(1);
				String name = resultset.getString(2);
				University university = new University(id, name);
				uSet.add(university);
			}

		} catch (SQLException e) {
			throw new UniversityAppDaoException("data retrive error.");//
		} finally {
			connectionutil.closefunnction(resultset);
			connectionutil.closefunnction(preparedstmt);
			connectionutil.closefunnction(connection);
		}
		return uSet;
	}

	@Override
	public boolean registerCollegeInDB(int universityId1, String collegeName, int rating)
			throws UniversityAppDaoException {
		boolean isInserted = false;
		Connection connection = connectionutil.getConnection();
		PreparedStatement st = null;
		String query = " insert into college(c_name,rating,university_id) values(?,?,?);";
		try {

			st = connection.prepareStatement(query);
			st.setString(1, collegeName);
			st.setInt(2, rating);
			st.setInt(3, universityId1);
			// System.out.println(query);
			int count = st.executeUpdate();

			if (count > 0) {
				isInserted = true;
			}

		} catch (SQLException e) {
			throw new UniversityAppDaoException("insertion error.");
		} finally {
			connectionutil.closefunnction(st);
			connectionutil.closefunnction(connection);
		}
		return isInserted;
	}

	@Override
	public List<UniversityDetails> displayUniversitydataFromDB(int universityId) throws UniversityAppDaoException {
		List<UniversityDetails> detailSet = new ArrayList<UniversityDetails>();
		Connection connection = connectionutil.getConnection();
		PreparedStatement preparedstmt = null;
		ResultSet resultset = null;
		String query = "  select university.u_id,university.u_name,college.c_id,college.c_name,college.rating "
				+ "from  college inner join university on university.u_id=college.university_id "
				+ "where university.u_id=?;";
		try {

			preparedstmt = connection.prepareStatement(query);
			preparedstmt.setInt(1, universityId);
			resultset = preparedstmt.executeQuery();
			while (resultset.next()) {
				int id = resultset.getInt(1);
				String name = resultset.getString(2);
				University university = new University(id, name);
				int id1 = resultset.getInt(3);
				String name1 = resultset.getString(4);
				float rating = resultset.getFloat(5);
				College college = new College(id1, name1, rating);
				UniversityDetails u = new UniversityDetails(university, college);
				detailSet.add(u);

			}

		} catch (SQLException e) {
			throw new UniversityAppDaoException("data retrive error.");
		} finally {
			connectionutil.closefunnction(resultset);
			connectionutil.closefunnction(preparedstmt);
			connectionutil.closefunnction(connection);
		}
		return detailSet;
	}

	@Override
	public List<College> displayCollegedataFromDB(int rating) throws UniversityAppDaoException {
		List<College> collegeList = new ArrayList<College>();
		Connection connection = connectionutil.getConnection();
		CallableStatement callableStatement = null;
		ResultSet resultset = null;
		String query = "{call getcollegedata (?)}";
		try {

			callableStatement = connection.prepareCall(query);
			callableStatement.setInt(1, rating);
			resultset = callableStatement.executeQuery();
			while (resultset.next()) {
				int id = resultset.getInt(1);
				String name = resultset.getString(2);
				float rating1 = resultset.getFloat(3);
				College college = new College(id, name, rating1);

				collegeList.add(college);

			}

		} catch (SQLException e) {
			throw new UniversityAppDaoException("data retrive error.");
		} finally {
			connectionutil.closefunnction(resultset);
			connectionutil.closefunnction(callableStatement);
			connectionutil.closefunnction(connection);
		}
		return collegeList;
	}

	@Override
	public boolean isUniversityNameDuplicate(String universityName) throws UniversityAppDaoException {
		boolean isFound = false;
		Connection con = connectionutil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		// System.out.println(particularUserId);
		String query = "select u_name from university where u_name=?;";

		try {

			st = con.prepareStatement(query);
			st.setString(1, universityName);
			// System.out.println(query);
			rs = st.executeQuery();
			if (rs.next() == true)
				isFound = true;
		} catch (SQLException e) {
			throw new UniversityAppDaoException("connection error.");
		} finally {
			connectionutil.closefunnction(rs);
			connectionutil.closefunnction(st);
			connectionutil.closefunnction(con);
		}

		return isFound;
	}

	@Override
	public boolean isUniversityNameFound(int universityId) throws UniversityAppDaoException {
		boolean isFound = false;
		Connection con = connectionutil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		// System.out.println(particularUserId);
		String query = "select u_name from university where u_id=?;";

		try {

			st = con.prepareStatement(query);
			st.setInt(1, universityId);
			rs = st.executeQuery();
			if (rs.next() == true)
				isFound = true;
		} catch (SQLException e) {
			throw new UniversityAppDaoException("connection error.");
		} finally {
			connectionutil.closefunnction(rs);
			connectionutil.closefunnction(st);
			connectionutil.closefunnction(con);
		}

		return isFound;
	}

}
