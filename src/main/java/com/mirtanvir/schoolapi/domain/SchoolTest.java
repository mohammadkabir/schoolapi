package com.mirtanvir.schoolapi.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mirtanvir.schoolapi.repositories.SchoolRepository;

@Component
public class SchoolTest {

	
	public static void main(String[] args) {
		
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(
				Configs.ROOT_CONTEXT_PATH);

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

		//School school;

		// Find contact by ID
		//school= schoolDao.findSchoolById(100l);
		
		
		
		

		// Add new contactkabir
		
		/* Temporarily commented
		School	myschool = new School();
		myschool.setName("Mission High Elementary");
		myschool.setApiScore(950);
		myschool.setCity("Freemont");
		myschool.setState("CA");
		myschool.setZip("95051");
		//myschool.setId(4);
		
		System.out.println("School Without schoold id:" + myschool);
		
		DemographicAPI myapi=new DemographicAPI();
		myapi.setDemographicType("Hispanic");
		myapi.setApiScore(750);
		//myapi.setId(5);
		DemographicAPI my_api1=new DemographicAPI();
		my_api1.setDemographicType("Asian");
		my_api1.setApiScore(980);
		//myapi1.setId(6);
		
		myschool.addApidetail(myapi);
		
		myschool.addApidetail(my_api1);
		
		System.out.println("MY SCHOOL After Adding New Dempgraphic Api in the Hash list and Before saving  " + myschool);
		
		
	*/	
		
		
	
		
		//School retrieveSchool=schoolDao.find;

	//Students mystudent=new Students();
	//mystudent.setFirstName("Rumi");
	//mystudent.setLastName("karim");
	///mystudent.setPhone("408-945-2265");
	//mystudent.setEmail("rumi@yahoo.com");
	
	//Users Parents1=new Users();
	//Parents1.setName("Maleka Karim");
	//Parents1.setAddress("444 Dempsey Road Milpitas,CA-95035");
	//Parents1.setHomePhone("408-941-9981");
	//Parents1.setMobile("408-83-5541");
	//Parents1.setEmail("maleka@hotmail.com");
	//Parents1.setRelationship("Mother");
	
	//School	myschool = new School();
	//myschool.setName("Berriyesa High Elementary");
	//myschool.setApiScore(910);
	//myschool.setCity("San jose");
	//myschool.setState("CA");
	//myschool.setZip("95051");
	
	// Set<Users> studentUsers = new HashSet<Users>();
	 //studentUsers.addAll(Arrays.asList(new Users[] {Parents1}));
	
	 //studentUsers.add(Parents1);
	 
	//mystudent.setMyUsers(studentUsers);
	
	//myschool.addStudentset(mystudent);
	//myschool.addUserset(Parents1);
	//schoolDao.saveSchool(myschool);	
	
	//System.out.println("School Retrieve from DataBase Here@@:  " + myschool);
	
	
	//Students student = schoolDao.getStudentById(14L);
	//Set<Users> myUsers = student.getMyUsers();
	
	Students student=schoolDao.findStudentWithUserid(7L);
	
  //List<School> student=schoolDao.findAllSchool();
	System.out.println("Student found by providing userid:"+student);
	
/*		
		
		Users parent1=new Users();
		
		parent1.setName("Mohammad Kabir");
		parent1.setAddress("444 Dempsey road,Milpitas,ca-95035");
		parent1.setHomePhone("408-941-9981");
		parent1.setMobile("408-836-5541");
		parent1.setEmail("boby@yahoo.com");
		parent1.setRelationship("Father");
		
		School schoolWithStudents=new School();
		schoolWithStudents.setName("Saint Joseph High School");
		schoolWithStudents.setApiScore(900);
		schoolWithStudents.setCity("Belmont");
		schoolWithStudents.setState("CA");
		schoolWithStudents.setZip("93034");
		
		Students myStudents=new Students();
		myStudents.setFirstName("Rifat");
		myStudents.setLastName("Kabir");
		myStudents.setPhone("408-836-2081");
		myStudents.setEmail("rifat@gmail.com");
		
		
		
		
		
		//myStudents.addUserset(parent1);
		//DemographicAPI my_api1=new DemographicAPI();
		//my_api1.setDemographicType("Asian");
		//my_api1.setApiScore(930);
		
		schoolWithStudents.addStudentset(myStudents);
		schoolWithStudents.addUserset(parent1);
		
		schoolDao.saveSchool(schoolWithStudents);
		
	*/	
		
		
	//	---------------------------------------
		
		
		
		
	/*	
		
		School retrieveSchool=schoolDao.findSchoolById((long) 8);	
		
			
		System.out.println("School Retrieve from DataBase Here:  " + retrieveSchool);
		
		retrieveSchool = schoolDao.getSchoolWithCommentsAndDemographicsDetails(7L);
		System.out.println(retrieveSchool);
		for (SchoolComment c:retrieveSchool.getMyComments()) {
			System.out.println(c.toString());
		}
		for (DemographicAPI d: retrieveSchool.getDemographicAPIdetails()) {
			System.out.println(d.toString());
		}
	
	*/	
		/*
		
		Set <DemographicAPI> retrivedDemographicapi=retrieveSchool.getDemographicAPIdetails();
		
		
		DemographicAPI Africanapi=new DemographicAPI();
		Africanapi.setDemographicType("African American");
		Africanapi.setApiScore(750);
		
		
		DemographicAPI Asianapi=new DemographicAPI();
		Asianapi.setDemographicType("Asian");
		Asianapi.setApiScore(900);
		
		retrieveSchool.addApidetail(Africanapi);
	
		retrieveSchool.addApidetail(Asianapi);
		
		*/
		
		/*
		retrieveSchool.setName("Rose Elementary");
		
		Set <DemographicAPI> retrivedDemographicapi=retrieveSchool.getDemographicAPIdetails();
		
		DemographicAPI chngedApi=null;
		
				for (DemographicAPI eachApi:retrivedDemographicapi )
						{
			
			            if(eachApi.getDemographicType().equalsIgnoreCase("asian"))
			            		{
			            	
			            	System.out.println("Found one school with : " +eachApi.getDemographicType()+"Demographic Type");
			            	eachApi.setDemographicType("Indian");   
			            	eachApi.setApiScore(900);
			            		}
							
						}
		
		
		
		
		*/
	/*	
		
	// Deleting the Hispanic Api	
		
		
		Set <DemographicAPI> retrivedDemographicapi=retrieveSchool.getDemographicAPIdetails();
		
		DemographicAPI deleteApi=null;
		
		for (DemographicAPI eachApi:retrivedDemographicapi )
				{
	
	            if(eachApi.getDemographicType().equalsIgnoreCase("Indian"))
	            		{
	            	
	            	
	            	
	            	System.out.println("Found one school with : " +eachApi.getDemographicType()+"Demographic Type");
	            	deleteApi=eachApi;
	            	
	            	
	            	//eachApi.setDemographicType("Indian");   
	            	//eachApi.setApiScore(900);
	            		}
					
				}

	
	
		
		
		retrieveSchool.removeApidetail(deleteApi);
		
		*/
		
		
	// Adding comments for Testing
		/*
		SchoolComment myComments=new SchoolComment();
		
		myComments.setComment("2014 Year school will be started on August 18,2014");
		
		schoolDao.saveSchool(retrieveSchool);

		*/
	
		
		//List <School>	myschools = schoolDao.findAllSchoolWithDetail();
		//listSchoolsWithDetail(myschools);
		

//	=========================================================================	
		
	/*	
		School	myschool = new School();
		myschool.setName("Harrsion High Elementary");
		myschool.setApiScore(850);
		myschool.setCity("Hayward");
		myschool.setState("CA");
		myschool.setZip("95051");
		
		DemographicAPI Africanapi=new DemographicAPI();
		Africanapi.setDemographicType("African American");
		Africanapi.setApiScore(750);	
		
		myschool.addApidetail(Africanapi);

		
		
SchoolComment myComments=new SchoolComment();
myComments.setComment("2014 Year school will be started on August 18,2014");
	
myschool.addCommentset(myComments);		
		
schoolDao.saveSchool(myschool);		

*/
//===================================================================================		
		
		
		
		
		
		
		
		
		
		
		
//	
		
		
		
		
/*	
		
		
		School school1 = schoolDao.findSchoolById(2L);
		DemographicAPI api = new DemographicAPI();
		api.setApiScore(896);
		api.setDemographicType("fas");
		api.setId(10);
		school1.getDemographicAPIdetails().add(api);
		schoolDao.saveSchool(school1);
		System.out.println(school1);
		
		
		/*List <School>	myschools = schoolDao.findAllSchoolWithDetail();
		listSchoolsWithDetail(myschools);
*/
		
	}

	private static void listContacts(List<School> incomingSchools) {
		System.out.println("");
		System.out.println("Listing contacts without details:");
		for (School school : incomingSchools) {
			System.out.println(school);
			System.out.println();
		}
	}

	private static void listSchoolsWithDetail(List<School> schools) {
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
