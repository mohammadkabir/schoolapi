package com.mirtanvir.schoolapi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="students")
public class Students {

private long id;
private String FirstName;
private String LastName;
private String Phone;
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

@Column(name="First_Name")
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
@Column(name="Last_Name")
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}

@Column(name="Phone")
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	Phone = phone;
}


@Column(name="Email")
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}

@Version
@Column(name = "version")
public int getVersion() {
	return this.version;

}

public void setVersion(int incomingVersion) {
	this.version = incomingVersion;

}




private Set<Users> myStudentUsers=new HashSet<Users>();



@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)

@ElementCollection(targetClass=Users.class)
@JoinTable(name = "school_user_detail", 
      //joinColumns = @JoinColumn(name = "school_id"), 
     // inverseJoinColumns = @JoinColumn(name = "user_id"))

joinColumns={@JoinColumn(name="school_id", referencedColumnName="school_id")},
inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="id")})




public Set<Users> getMyUsers() {

	return this.myStudentUsers;
}


public void setMyUsers(Set<Users> incoming_users) {
	this.myStudentUsers = incoming_users;
}


@Override
public String toString() {
	return "Students [id=" + id + ", FirstName=" + FirstName + ", LastName="
			+ LastName + ", Phone=" + Phone + ", Email=" + Email + ", version="
			+ version + "]";
}


}// end of class
