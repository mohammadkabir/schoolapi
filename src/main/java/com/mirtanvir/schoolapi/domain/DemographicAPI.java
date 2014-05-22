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
@Table(name="demographics_api")
public class DemographicAPI {
	@Override
	public String toString() {
		return "DemographicAPI [id=" + id
				+ ", schoolId=" + schoolId + ", demographicType="
				+ demographicType + ", apiScore=" + apiScore + "]";
	}
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
	public String getDemographicType() {
		return demographicType;
	}
	public void setDemographicType(String demographicType) {
		this.demographicType = demographicType;
	}
	public double getApiScore() {
		return apiScore;
	}
	public void setApiScore(double apiScore) {
		this.apiScore = apiScore;
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
	private long id;
	
	@Column(name="school_id")
	private long schoolId;
	
	@Column(name="demographic_type")
	private String demographicType;
	
	@Column(name="api_score")
	private double apiScore;
	
}