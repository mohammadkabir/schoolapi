package com.mirtanvir.schoolapi.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;






@Entity
	@Table(name="subjects")


	public class Subjects {


	private long id;
	private String name;
	private String desc;
    private long grader;
    private int version;
	
    
   private Set<Books> mySubjBooks=new HashSet<Books>();

    
    
    public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Column(name="desc")
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	@Column(name="grade")
	public long getGrader() {
		return grader;
	}
	public void setGrader(long grader) {
		this.grader = grader;
	}
	
	
	
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "subject_id")
	public Set<Books> getMySubjectdetails() {
		return this.mySubjBooks;
	}

	public void setMySubjectdetails(Set<Books> incoming_books) {
		this.mySubjBooks = incoming_books;
	}
	
	
	
	
	
	public void addBooks(Books incoming_books) {

		// incoming_apidetail.setMyschool(this);

		getMySubjectdetails().add(incoming_books);
	}

	public void removeBooks(Books incoming_books) {

		getMySubjectdetails().remove(incoming_books);

		

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Subjects [id=" + id + ", name=" + name + ", desc=" + desc
				+ ", grader=" + grader + ", version=" + version
				+ ", mySubjBooks=" + mySubjBooks + "]";
	}




    
    
    
    
    






}//end of class
