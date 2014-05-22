package com.mirtanvir.schoolapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="school_comment")
public class SchoolComment {
	
	/*
	@Override
	public String toString() {
		return "DemographicAPI [id=" + id
				+ ", schoolId=" + schoolId + ", demographicType="
				+ demographicType + ", apiScore=" + apiScore + "]";
	}
*/
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "school_id", insertable = false, updatable = false)
	private School myschool;
	
	
	public School getMyschool() {
		return myschool;
	}
	public void setMyschool(School myschool) {
		this.myschool = myschool;
	}


	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="comm_id")
	
	private long id;
	
	@Column(name="school_id")
	private long schoolId;
	
	@Column(name="comment")
	private String comment;
	
	
	
}