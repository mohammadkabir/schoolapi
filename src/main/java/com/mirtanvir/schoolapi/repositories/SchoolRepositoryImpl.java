package com.mirtanvir.schoolapi.repositories;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.management.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mirtanvir.schoolapi.domain.*;

@Service("SchoolRepository")
@Repository("SchoolRepository")
@Transactional
public class SchoolRepositoryImpl implements SchoolRepository {

	private static final String Students = null;

	private Log log = LogFactory.getLog(SchoolRepositoryImpl.class);

	private SessionFactory sessionFactory;

	private Object object;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Transactional(readOnly = true) public List<School> findAllSchool() {
	 * return sessionFactory.getCurrentSession().createQuery("from School s ")
	 * .list(); }
	 */

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
		// return (School)
		// sessionFactory.getCurrentSession().createQuery("select  s from School s  join s.myComments a where s.id = :id").setParameter("id",
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

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<School> findAllSchool() {

		Session currentSession = null;
		currentSession = sessionFactory.getCurrentSession();

		// School school = (School) currentSession.get(School.class, schoolId);
		// Hibernate.initialize(school.getMyComments());

		return currentSession
				.createQuery(
						"select student_id,school_id, user_id,First_Name from student st, school_user_detail sd where st.school_id = sd.school_id")
				.list();

		// return
		// currentSession.createQuery("select student_id,First_Name from student st Where st.student_id=("+"select sud.student_id from  student_user_detail sud where sud.user_id = :id"+")"+")";

		// return school;
	}

	@Override
	public Students getStudentById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Students currStudent = (Students) currentSession
				.get(Students.class, id);
		if (currStudent != null) {
			Hibernate.initialize(currStudent.getMyUsers());
		}
		return currStudent;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	// public List<Students> findStudentWithUserid(Long MyUserid) {
	public Students findStudentWithUserid(Long MyUserid) {
		Session currentSession = null;
		currentSession = sessionFactory.getCurrentSession();

		// School school = (School) currentSession.get(School.class, schoolId);
		// Hibernate.initialize(school.getMyComments());

		// return
		// currentSession.createQuery("select student_id,school_id, user_id,First_Name from student st, school_user_detail sd where st.school_id = sd.school_id").list();

		// System.out.println("Id Came here--->"+MyUserid);

		// ///return (List<com.mirtanvir.schoolapi.domain.Students>)
		// currentSession.createQuery("select s from Students s left join fetch s.myUsers Where s.id in("+"select sud.id from  Users sud where sud.id = :id)").setParameter("id",
		// MyUserid).list();

		// return (com.mirtanvir.schoolapi.domain.Students)
		// currentSession.createSQLQuery("SELECT *  FROM `students` s WHERE s.id = ("+
		// "SELECT sud.student_id FROM student_user_detail sud WHERE sud.user_id =:idc)").setParameter("id",
		// MyUserid).uniqueResult();

		// String hql = "select distinct s from Students s "
		// +"join s.myUsers m " +"where m.id in (:MyUserid)";

		// org.hibernate.Query query = currentSession.createQuery(hql);
		// query.setParameter("id", MyUserid);

		// return (List<com.mirtanvir.schoolapi.domain.Students>) (object =
		// query.list());

		return (Students) currentSession
				.createQuery(
						"select distinct s from Students s left join fetch s.myUsers m left join fetch s.mySubjects j   where m.id = :id")
				.setParameter("id", MyUserid).uniqueResult();

		// return (Students)
		// currentSession.createQuery("select distinct new Name(First_Name, Last_Name) from Students s left join fetch s.myUsers m where m.id = :id").setParameter("id",
		// MyUserid).uniqueResult();

	}

}
