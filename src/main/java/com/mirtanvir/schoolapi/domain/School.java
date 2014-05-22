package com.mirtanvir.schoolapi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "schools")
// ------------------------------------------------------
@NamedQueries({
		@NamedQuery(name = "School.findById", query = "select distinct s from School s left join fetch s.demographicAPIdetails a  where s.id = :id"),

		@NamedQuery(name = "School.findAllWithDetail", query = "select distinct s from School s left join fetch s.demographicAPIdetails a")})

		

// ==================================================================
public class School {

	@Override
	public String toString() {
		return "School [id=" + id + ", school_name=" + school_name + ", state="
				+ state + ", city=" + city + ", zip=" + zip + ", apiScore="
				+ apiScore + ", demographicAPIdetails=" + demographicAPIdetails
				+ ", version=" + version + "]";
	}

	
	//@NamedQuery(name = "School.findAllWithDetail", query = "select distinct s from School s left join fetch s.demographicAPIdetails a")})

	
	
	private long id;

	private String school_name;

	// private String addressLine1;

	// private String addressLine2;

	private String state;

	private String city;

	private String zip;

	private float apiScore;

	private Set<DemographicAPI> demographicAPIdetails = new HashSet<DemographicAPI>();

	private Set<SchoolComment> schoolComments = new HashSet<SchoolComment>();

	
	
	private int version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long incomingId) {
		this.id = incomingId;
	}

	@Column(name = "name")
	public String getName() {
		return this.school_name;
	}

	public void setName(String name) {
		this.school_name = name;
	}

	/*
	 * public String getAddressLine1() { return addressLine1; }
	 * 
	 * public void setAddressLine1(String addressLine1) { this.addressLine1 =
	 * addressLine1; }
	 * 
	 * public String getAddressLine2() { return addressLine2; }
	 * 
	 * public void setAddressLine2(String addressLine2) { this.addressLine2 =
	 * addressLine2; }
	 */
	@Column(name = "state")
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "city")
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "zip")
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "apiScore")
	public float getApiScore() {
		return this.apiScore;
	}

	public void setApiScore(float apiScore) {
		this.apiScore = apiScore;
	}

	//====== Added by kabir: ====For apiDetails
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "myschool", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<DemographicAPI> getDemographicAPIdetails() {
		return this.demographicAPIdetails;
	}

	public void setDemographicAPIdetails(Set<DemographicAPI> incoming_apidetail) {
		this.demographicAPIdetails = incoming_apidetail;
	}

	
	//=====================For comments===============================================
	

	
	@OneToMany(fetch = FetchType.EAGER, mappedBy ="myschool", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<SchoolComment> getComments() {
		return this.schoolComments;
	}

	public void setComments(Set<SchoolComment> incoming_comments) {
		this.schoolComments = incoming_comments;
	}
	
	
	
	
	
	
	// This Two function is needed to test form main class  for Api detail.
	// ---------------------------------------------------------------------------
	public void addApidetail(DemographicAPI incoming_apidetail) {

		incoming_apidetail.setMyschool(this);

		getDemographicAPIdetails().add(incoming_apidetail);
	}

	public void removeApidetail(DemographicAPI incoming_apidetail) {

		getDemographicAPIdetails().remove(incoming_apidetail);

	}

	
	//======================================for comments==================================================
	public void addComments(SchoolComment incoming_comments) {

		incoming_comments.setMyschool(this);

		getComments().add(incoming_comments);
	}

	public void removeComments(SchoolComment incoming_comments) {

		
		getComments().remove(incoming_comments);
		
		
	}

		
	@Version
	@Column(name = "version")
	public int getVersion() {
		return this.version;

	}

	public void setVersion(int incomingVersion) {
		this.version = incomingVersion;

	}

}
