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
@Entity
@Table(name="users")

public class Users {

private long id;
		private String Name;
		private String Address;
		private String Mobile;
		private String HomePhone;
		private String Relationship;
		private String Email;
		private int version;


@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}

@Column(name="Name")
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}

@Column(name="Address")
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}

@Column(name="Mobile")
public String getMobile() {
	return Mobile;
}
public void setMobile(String mobile) {
	Mobile = mobile;
}

@Column(name="Home_phone")
public String getHomePhone() {
	return HomePhone;
}
public void setHomePhone(String homePhone) {
	HomePhone = homePhone;
}
@Column(name="Relationship")
public String getRelationship() {
	return Relationship;
}
public void setRelationship(String relationship) {
	Relationship = relationship;
}

@Column(name="Email")
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}

@Column(name="Version")
public int getVersion() {
	return version;
}

public void setVersion(int version) {
	this.version = version;
}

	
		
@Override
public String toString() {
	return "Users [id=" + id + ", Name=" + Name + ", Address=" + Address
			+ ", Mobile=" + Mobile + ", HomePhone=" + HomePhone
			+ ", Relationship=" + Relationship + ", Email=" + Email
			+ ", version=" + version + "]";
}

	



}// end of class
