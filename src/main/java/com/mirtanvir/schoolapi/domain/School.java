package com.mirtanvir.schoolapi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
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
/*@NamedQueries({
// @NamedQuery(name = "School.findById", query =
// "select distinct s from School s left join fetch s.demographicAPIdetails a  where s.id = :id"),

		@NamedQuery(name = "School.findById", query = "select distinct s from School s left join fetch s.demographicAPIdetails a  where s.id = :id"),

//		 @NamedQuery(name = "School.getComments", query =
//		"select * from SchoolComment c where c."),

		// @NamedQuery(name = "School.findById", query =
		// "select distinct s from School s left join fetch s.demographicAPIdetails a left join fetch s.commentSet k  where s.id = :id"),

		@NamedQuery(name = "School.findAllWithDetail", query = "select distinct s from School s left join fetch s.demographicAPIdetails a") 
		
	}
)*/
// =============================================================================================================================================
public class School {
	//
	// @Override
	// public String toString() {
	// return "School [id=" + id + ", school_name=" + school_name + ", state="
	// + state + ", city=" + city + ", zip=" + zip + ", apiScore="
	// + apiScore + ", demographicAPIdetails!!!=" + demographicAPIdetails
	// + ", school version=" + version +",Comments="+myComments+ "]";
	// }
	//

	// @NamedQuery(name = "School.findAllWithDetail", query =
	// "select distinct s from School s left join fetch s.demographicAPIdetails a")})

	private long id;

	@Override
	public String toString() {
		return "School [id=" + id + ", school_name=" + school_name + ", state="
				+ state + ", city=" + city + ", zip=" + zip + ", apiScore="
				+ apiScore + ", version=" + version + "]";
	}

	private String school_name;

	// private String addressLine1;

	// private String addressLine2;

	private String state;

	private String city;

	private String zip;

	private float apiScore;

	private Set<DemographicAPI> demographicAPIdetails = new HashSet<DemographicAPI>();

	// private Set<SchoolComment> commentSet = new HashSet<SchoolComment>();

	private Set<SchoolComment> myComments = new HashSet<SchoolComment>();

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

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "school_id")
	public Set<DemographicAPI> getDemographicAPIdetails() {
		return this.demographicAPIdetails;
	}

	public void setDemographicAPIdetails(Set<DemographicAPI> incoming_apidetail) {
		this.demographicAPIdetails = incoming_apidetail;
	}

	public void addApidetail(DemographicAPI incoming_apidetail) {

		// incoming_apidetail.setMyschool(this);

		getDemographicAPIdetails().add(incoming_apidetail);
	}

	public void removeApidetail(DemographicAPI incoming_apidetail) {

		getDemographicAPIdetails().remove(incoming_apidetail);

		System.out.println("Removing this: " + incoming_apidetail
				+ "Demographich Api From the  HashSet<> : ");

	}

	// =====================For Comments==================================

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "school_id")
	public Set<SchoolComment> getMyComments() {

		return this.myComments;
	}

	public void setMyComments(Set<SchoolComment> incoming_comments) {
		this.myComments = incoming_comments;
	}

	public void addCommentset(SchoolComment incoming_comments) {

		// incoming_apidetail.setMyschool(this);

		getMyComments().add(incoming_comments);

	}

	public void removeCommentset(SchoolComment incoming_comments) {

		getMyComments().remove(incoming_comments);

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
