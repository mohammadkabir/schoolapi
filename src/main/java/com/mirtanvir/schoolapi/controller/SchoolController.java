package com.mirtanvir.schoolapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mirtanvir.schoolapi.domain.School;
import com.mirtanvir.schoolapi.repositories.SchoolRepository;

@Service
@Controller
@RequestMapping("/api**")
public class SchoolController {

    @Autowired
    private SchoolRepository repo;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    private List<School> getAllSchools() {
        return repo.findAllSchool();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    private School getOneSchool(@PathVariable("id") long id) {
        System.out.println(id);

        return repo.findSchoolById(id);
    }

    /*
     * @RequestMapping(value = "/zipcode/{zipCode}", method = RequestMethod.GET)
     * 
     * @ResponseBody private Page<School> getSchoolsInAZipCode(
     * 
     * @PathVariable("zipCode") String zipCode, Pageable page) {
     * System.out.println("Searching for schools in zipcode" + zipCode); return
     * repo.getByZip(zipCode, page);
     * 
     * }
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    private School createSchool(@RequestBody School school) {
        School newSchool = repo.saveSchool(school);
        return newSchool;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    private School updateSchool(@PathVariable("id") long id,
            @RequestBody School school) {
        School existingSchool = repo.findSchoolById(id);
        if (existingSchool != null && existingSchool.getId() == school.getId()) {
            System.out.println("Saving the object with id" + id);
            return repo.saveSchool(school);
        }
        return null;
    }

    // ===========================================================

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    private void deleteSchool(@PathVariable("id") long id) {
        School existingSchool = repo.findSchoolById(id);
        if (existingSchool != null) {
            System.out.println("Deleting the object with id" + id);
            repo.deleteSchool(existingSchool);
        }

    }

}
