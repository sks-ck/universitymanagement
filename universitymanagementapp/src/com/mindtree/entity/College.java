package com.mindtree.entity;

public class College {
	private int collegeId;
	private String collegeName;
	private float rating;

	public College() {
	}

	public College(int collegeId, String collegeName, float rating) {
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.rating = rating;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", rating=" + rating + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + collegeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		College other = (College) obj;
		if (collegeId != other.collegeId)
			return false;
		return true;
	}

}
