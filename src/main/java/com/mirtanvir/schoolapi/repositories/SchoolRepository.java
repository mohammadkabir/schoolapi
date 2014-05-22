package com.mirtanvir.schoolapi.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mirtanvir.schoolapi.domain.School;

//public interface SchoolRepository extends PagingAndSortingRepository<School, Long> {
	
	//public Page<School> getByZip(String zipCode, Pageable page);



//----------------------------------------------------

public interface SchoolRepository {

	// Find all contacts
	public List<School> findAllSchool();
	
	// Find all contacts with telephone and hobbies
	public List<School> findAllSchoolWithDetail();
	
	// Find a school with details by id
	public School findSchoolById(Long id);
	
	// Insert or update a school
	public School saveSchool(School contact);
	
	// Delete a school
	public void deleteSchool(School school);
}
