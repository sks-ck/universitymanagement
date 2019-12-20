package com.mindtree.dao;

import java.util.List;
import java.util.Set;

import com.mindtree.entity.College;
import com.mindtree.entity.University;
import com.mindtree.entity.UniversityDetails;
import com.mindtree.exception.daoexception.UniversityAppDaoException;

public interface UniversityAppDao {

	/**
	 * @param universityId
	 * @param universityName
	 * @return
	 * @throws UniversityAppDaoException
	 */
	boolean registerUniversityToDB(int universityId, String universityName) throws UniversityAppDaoException;

	/**
	 * @return
	 * @throws UniversityAppDaoException
	 */
	Set<University> detailsUniversityFromDB() throws UniversityAppDaoException;

	/**
	 * @param universityId1
	 * @param collegeName
	 * @param rating
	 * @return
	 * @throws UniversityAppDaoException
	 */
	boolean registerCollegeInDB(int universityId1, String collegeName, int rating) throws UniversityAppDaoException;

	/**
	 * @param universityId
	 * @return
	 * @throws UniversityAppDaoException
	 */
	List<UniversityDetails> displayUniversitydataFromDB(int universityId) throws UniversityAppDaoException;

	/**
	 * @param rating
	 * @return
	 * @throws UniversityAppDaoException
	 */
	List<College> displayCollegedataFromDB(int rating) throws UniversityAppDaoException;

	/**
	 * @param universityName
	 * @return
	 * @throws UniversityAppDaoException
	 */
	boolean isUniversityNameDuplicate(String universityName) throws UniversityAppDaoException;

	/**
	 * @param universityId
	 * @return
	 * @throws UniversityAppDaoException
	 */
	boolean isUniversityNameFound(int universityId) throws UniversityAppDaoException;

}
