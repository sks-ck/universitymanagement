package com.mindtree.client;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.mindtree.entity.College;
import com.mindtree.entity.University;
import com.mindtree.entity.UniversityDetails;
import com.mindtree.exception.serviceexception.UniversityAppServiceException;
import com.mindtree.service.UniversityAppService;
import com.mindtree.service.serviceimpl.UniversityAppServiceImpl;

public class AppRunner {

	private static Scanner scanner = new Scanner(System.in);
	private static UniversityAppService universityappservice = new UniversityAppServiceImpl();

	public static void main(String[] args) {

		char check = 0;
		do {
			System.out.println("enter 1 for university registration.\n" + "enter 2 for college registration.\n"
					+ "enter 3 for university details by id.\n" + "enter 4 for college details by rating.\n"
					+ "enter 5 for exit ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				universityRegistration();

				break;
			case 2:
				collegeRegistration();

				break;
			case 3:
				displayUniversitydetails();
				break;
			case 4:
				getCollegeDetails();
				break;
			case 5:
				System.out.println("you have exited.");
				System.exit(0);
			}
			System.out.println("Do you want to continue[y/n] :");
			check = scanner.next().charAt(0);

		} while (check == 'Y' || check == 'y');

	}

	private static void collegeRegistration() {
		System.out.println(" details of university");
		Set<University> uSet = null;
		try {
			uSet = universityappservice.detailsUniversity();
		} catch (UniversityAppServiceException e) {
			System.out.println(e);

		}
		for (University university : uSet) {
			System.out.println("university id: " + university.getUniversityId());
			System.out.println("university name: " + university.getUniversityName());
		}
		System.out.println("enter university id: ");
		int universityId1 = scanner.nextInt();
		scanner.nextLine();
		System.out.println("enter college name: ");
		String collegeName = scanner.nextLine();
		System.out.println("enter college rating: ");
		int rating = scanner.nextInt();
		scanner.nextLine();
		boolean isInserted1 = false;
		try {
			isInserted1 = universityappservice.registerCollege(universityId1, collegeName, rating);
		} catch (UniversityAppServiceException e) {
			System.out.println(e);
		}
		if (isInserted1 == true)
			System.out.println("college registration successful.");
	}

	private static void universityRegistration() {
		System.out.println("enter university id: ");
		int universityId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("enter university name: ");
		String universityName = scanner.nextLine();
		boolean isInserted = false;
		try {
			isInserted = universityappservice.registerUniversity(universityId, universityName);
		} catch (UniversityAppServiceException e) {
			System.out.println(e);
		}
		if (isInserted == true)
			System.out.println("Registration successful with id: " + universityId + "and name: " + universityName);

	}

	private static void getCollegeDetails() {
		System.out.println("enter college rating: ");
		int rating = scanner.nextInt();
		List<College> collegeList = null;
		try {
			collegeList = universityappservice.displayCollegedata(rating);
			for (College college : collegeList) {
				System.out.println(college);
			}

		} catch (UniversityAppServiceException e) {
			System.out.println(e);
		}
	}

	private static void displayUniversitydetails() {

		System.out.println("enter university id: ");
		int universityId = scanner.nextInt();
		List<UniversityDetails> detailSet = null;
		try {
			detailSet = universityappservice.displayUniversitydata(universityId);
			Collections.sort(detailSet);
			for (UniversityDetails universityDetails : detailSet) {
				System.out.println(universityDetails.getUniversity());
				System.out.println(universityDetails.getColleges());
			}
		} catch (UniversityAppServiceException e) {
			System.out.println(e);
		}

	}
}
