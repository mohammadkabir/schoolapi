package com.mirtanvir.schoolapi.repositories;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mirtanvir.schoolapi.domain.*;

@Repository("SchoolRepository")
@Transactional
public class SchoolRepositoryImpl implements SchoolRepository {

	private Log log = LogFactory.getLog(SchoolRepositoryImpl.class);

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	
	
	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<School> findAllSchool() {
		return sessionFactory.getCurrentSession().createQuery("from School s ")
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<School> findAllSchoolWithDetail() {
		return sessionFactory.getCurrentSession()
				.getNamedQuery("School.findAllWithDetail").list();

		// return
		// sessionFactory.getCurrentSession().createQuery(" from School s DemographicAPI d SchoolComment c where s.id=d.sc  ").list();

	}

	public School findSchoolById(Long Myid) {

		return (School) sessionFactory.getCurrentSession()
			.getNamedQuery("School.findById").setParameter("id", Myid)
			.uniqueResult();

		// return (School)
		//return (School) sessionFactory.getCurrentSession().createQuery("select  s from School s  join s.myComments a where s.id = :id").setParameter("id",
		// Myid).uniqueResult();

	}

	public School getSchoolWithCommentsAndDemographicsDetails(Long schoolId) {
		Session currentSession = null;
		currentSession = sessionFactory.getCurrentSession();
		School school = (School) currentSession.get(School.class, schoolId);
		Hibernate.initialize(school.getMyComments());
		Hibernate.initialize(school.getDemographicAPIdetails());
		Hibernate.initialize(school.getMyStudents());
		Hibernate.initialize(school.getMyUsers());
		return school;
	}

	public School getSchoolWithComments(Long schoolId) {

		Session currentSession = null;
		currentSession = sessionFactory.getCurrentSession();

		School school = (School) currentSession.get(School.class, schoolId);
		Hibernate.initialize(school.getMyComments());
		return school;
	}
	
	

	public School saveSchool(School school) {

		sessionFactory.getCurrentSession().saveOrUpdate(school);

		System.out.println("MY SCHOOL in the saveOrupdate funtion  " + school);
		System.out.println("MY API Details in the saveOrupdate funtion  "
				+ school.getDemographicAPIdetails());

		return school;
	}

	public void deleteSchool(School school) {
		sessionFactory.getCurrentSession().delete(school);
		log.info("Contact deleted with id: " + school.getId());
	}

}
