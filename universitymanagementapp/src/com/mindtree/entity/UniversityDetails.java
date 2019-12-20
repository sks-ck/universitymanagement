package com.mindtree.entity;

public class UniversityDetails implements Comparable<UniversityDetails> {

	private University university;
	private College colleges;

	public UniversityDetails() {
	}

	public UniversityDetails(University university, College colleges) {
		this.university = university;
		this.colleges = colleges;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public College getColleges() {
		return colleges;
	}

	public void setColleges(College colleges) {
		this.colleges = colleges;
	}

	@Override
	public String toString() {
		return "UniversityDetails [university=" + university + ", colleges=" + colleges + "]";
	}

	@Override
	public int compareTo(UniversityDetails a) {
		return (int) (a.getColleges().getRating()-this.getColleges().getRating());
	}

}
