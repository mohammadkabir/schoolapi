package com.mirtanvir.schoolapi.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mirtanvir.schoolapi.repositories.SchoolRepository;

@Component
public class SchoolTest {

	
	public static void main(String[] args) {
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(
				"D:\\Users\\245546\\src\\school-api\\src\\main\\resources\\META-INF\\spring\\root-context.xml");

		//ctx.refresh();
		SchoolTest p = ctx.getBean(SchoolTest.class);
        p.start(args);
	}

	
	@Autowired
	SchoolRepository schoolDao;
	public void start(String[] args) {

		
		// SchoolRepository schoolDao = ctx.getBean( SchoolRepository.class);//
		// check this line later

		// List contacts without details
		//List<School> schools = schoolDao.findAllSchool(); //Deleted by kabir add later

		//listContacts(schools);//Deleted by kabir add later

		// List contacts with details
		//schools = schoolDao.findAllSchoolWithDetail();//Deleted by kabir add later
		//listContactsWithDetail(schools);//Deleted by kabir add later

		School school;

		// Find contact by ID
		school = schoolDao.findSchoolById(1l);
		System.out.println("");
		System.out.println("School with id  1 before new school added:" + school);
		System.out.println("");

		// Add new contactkabir
		School	myschool = new School();
		myschool.setName("Randal Elementaqry added kabirnew_COMMENTS");
		myschool.setApiScore(7);
		myschool.setCity("Fremont");
		myschool.setState("CA");
		myschool.setZip("94086");
		
		
		DemographicAPI myapi=new DemographicAPI();
		
		myapi.setDemographicType("HispanicNEW");
		myapi.setApiScore(699);
		myapi.setDemographicType("Asian");
		myapi.setApiScore(899);
		
		myapi.setDemographicType("FilipinoNew");
		myapi.setApiScore(699);
		myapi.setDemographicType("African American");
		myapi.setApiScore(650);
		
		myapi.setMyschool(myschool);
	//==================================================================	
		//myschool.addApidetail(myapi);
		
		
		//SchoolComment myComment=new SchoolComment(); 
		
		//myComment.setComment("Philtrip on Tuesday December 19 2013");
		//myschool.addComments(myComment);
		
		
		schoolDao.saveSchool(myschool);
		
		
		// contactDao.save(contact);
	
		
		List <School>	myschools = schoolDao.findAllSchoolWithDetail();
		listContactsWithDetail(myschools);

		
	}

	private static void listContacts(List<School> incomingSchools) {
		System.out.println("");
		System.out.println("Listing contacts without details:");
		for (School school : incomingSchools) {
			System.out.println(school);
			System.out.println();
		}
	}

	private static void listContactsWithDetail(List<School> schools) {
		System.out.println("");
		System.out.println("Listing contacts with details:");
		for (School school : schools) {
			System.out.println(school);
			// if (school.getSchoolApiDetail() != null) {
			// for (SchoolApidetail apiDetail: school.getSchoolApiDetail()) {
			// System.out.println(apiDetail);
			// }
			// }
			// if (contact.getHobbies() != null) {
			// for (Hobby hobby: contact.getHobbies()) {
			// System.out.println(hobby);
			// }
			// }
			System.out.println();
		}
	}

}// end of class

