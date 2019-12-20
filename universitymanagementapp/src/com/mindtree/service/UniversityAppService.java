package com.mindtree.service;

import java.util.List;
import java.util.Set;

import com.mindtree.entity.College;
import com.mindtree.entity.University;
import com.mindtree.entity.UniversityDetails;
import com.mindtree.exception.serviceexception.UniversityAppServiceException;

public interface UniversityAppService {

	/**
	 * @param universityId
	 * @param universityName
	 * @return
	 * @throws UniversityAppServiceException
	 */
	boolean registerUniversity(int universityId, String universityName) throws UniversityAppServiceException;

	/**
	 * @return
	 * @throws UniversityAppServiceException
	 */
	Set<University> detailsUniversity() throws UniversityAppServiceException;

	/**
	 * @param universityId1
	 * @param collegeName
	 * @param rating
	 * @return
	 * @throws UniversityAppServiceException
	 */
	boolean registerCollege(int universityId1, String collegeName, int rating) throws UniversityAppServiceException;

	/**
	 * @param universityId 
	 * @return
	 * @throws UniversityAppServiceException
	 */
	List<UniversityDetails> displayUniversitydata(int universityId) throws UniversityAppServiceException;

	/**
	 * @param rating
	 * @return
	 * @throws UniversityAppServiceException
	 */
	List<College> displayCollegedata(int rating) throws UniversityAppServiceException;

}
