package com.mindtree.entity;

public class University {
	private int universityId;
	private String universityName;

	public University() {

	}

	public University(int universityId, String universityName) {
		this.universityId = universityId;
		this.universityName = universityName;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	@Override
	public String toString() {
		return "University [universityId=" + universityId + ", universityName=" + universityName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + universityId;
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
		University other = (University) obj;
		if (universityId != other.universityId)
			return false;
		return true;
	}

}
