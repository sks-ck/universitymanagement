package com.mindtree.service.serviceimpl;

import java.util.List;
import java.util.Set;

import com.mindtree.dao.UniversityAppDao;
import com.mindtree.dao.daoimpl.UniversityAppDaoImpl;
import com.mindtree.entity.College;
import com.mindtree.entity.University;
import com.mindtree.entity.UniversityDetails;
import com.mindtree.exception.daoexception.UniversityAppDaoException;
import com.mindtree.exception.serviceexception.InvalidRatingException;
import com.mindtree.exception.serviceexception.NoDataAvailableException;
import com.mindtree.exception.serviceexception.UniversityAppServiceException;
import com.mindtree.exception.serviceexception.UniversityNameDuplicateException;
import com.mindtree.exception.serviceexception.UniversityNameNotFoundException;
import com.mindtree.service.UniversityAppService;

public class UniversityAppServiceImpl implements UniversityAppService {
	private UniversityAppDao universityappdao = new UniversityAppDaoImpl();

	@Override
	public boolean registerUniversity(int universityId, String universityName) throws UniversityAppServiceException {
		boolean isInserted = false;
		try {
			if (universityappdao.isUniversityNameDuplicate(universityName) == true)
				throw new UniversityNameDuplicateException("University Name Duplicate");
			isInserted = universityappdao.registerUniversityToDB(universityId, universityName);
		} catch (UniversityAppDaoException | UniversityNameDuplicateException e) {
			throw new UniversityAppServiceException(e);
		}
		return isInserted;
	}

	@Override
	public Set<University> detailsUniversity() throws UniversityAppServiceException {
		Set<University> uSet = null;
		try {
			uSet = universityappdao.detailsUniversityFromDB();
		} catch (UniversityAppDaoException e) {
			throw new UniversityAppServiceException(e);
		}
		return uSet;
	}

	@Override
	public boolean registerCollege(int universityId1, String collegeName, int rating)
			throws UniversityAppServiceException {
		boolean isInserted;
		try {
			if (rating > 10 || rating < 0)
				throw new InvalidRatingException("invalid rating.");
			isInserted = universityappdao.registerCollegeInDB(universityId1, collegeName, rating);
		} catch (UniversityAppDaoException | InvalidRatingException e) {
			throw new UniversityAppServiceException(e);
		}
		return isInserted;
	}

	@Override
	public List<UniversityDetails> displayUniversitydata(int universityId) throws UniversityAppServiceException {
		List<UniversityDetails> detailSet;
		try {
			if (universityappdao.isUniversityNameFound(universityId) == false)
				throw new UniversityNameNotFoundException("University Name not found.");
			detailSet = universityappdao.displayUniversitydataFromDB(universityId);
		} catch (UniversityAppDaoException | UniversityNameNotFoundException e) {
			throw new UniversityAppServiceException(e);
		}
		return detailSet;
	}

	@Override
	public List<College> displayCollegedata(int rating) throws UniversityAppServiceException {
		List<College> collegeList;
		try {
			if (rating > 10 || rating < 0)
				throw new InvalidRatingException("invalid rating.");
			collegeList = universityappdao.displayCollegedataFromDB(rating);
			if(collegeList.isEmpty()==true)
					throw new NoDataAvailableException("no data available");
		} catch (UniversityAppDaoException | InvalidRatingException|NoDataAvailableException e) {
			throw new UniversityAppServiceException(e.getMessage(),e);
		}
		return collegeList;
	}

}
