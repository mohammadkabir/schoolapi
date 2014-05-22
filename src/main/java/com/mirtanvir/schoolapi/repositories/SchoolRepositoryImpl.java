package com.mirtanvir.schoolapi.repositories;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mirtanvir.schoolapi.domain.School;




@Repository("SchoolRepository")
@Transactional
public class SchoolRepositoryImpl implements SchoolRepository {



	
	
		
		private Log log = LogFactory.getLog(SchoolRepositoryImpl.class);
		
		private SessionFactory sessionFactory;	

		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		@Resource(name="sessionFactory")
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		@SuppressWarnings("unchecked")
		@Transactional(readOnly=true)
		public List<School> findAllSchool() {
			return sessionFactory.getCurrentSession().createQuery("from School s ").list();
		}

		@SuppressWarnings("unchecked")
		public List<School> findAllSchoolWithDetail() {
			return sessionFactory.getCurrentSession().getNamedQuery("School.findAllWithDetail").list();
		
			//return sessionFactory.getCurrentSession().createQuery(" from School s DemographicAPI d SchoolComment c where s.id=d.sc  ").list();
		
		}

		public School findSchoolById(Long id) {
			//return (School) sessionFactory.getCurrentSession().
				//	getNamedQuery("Contact.findById").setParameter("id", id).uniqueResult();
		
			return (School) sessionFactory.getCurrentSession().
						getNamedQuery("School.findById").setParameter("id", id).uniqueResult();
			
			
		
		
		
		}

		public School saveSchool(School school) {
			sessionFactory.getCurrentSession().saveOrUpdate(school);
			log.info("Contact saved with id: " + school.getId());
			return school;
		}

		public void deleteSchool(School school) {
			sessionFactory.getCurrentSession().delete(school);
			log.info("Contact deleted with id: " + school.getId());
		}
		
	}





















