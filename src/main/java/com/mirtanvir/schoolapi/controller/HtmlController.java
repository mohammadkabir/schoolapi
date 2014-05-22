package com.mirtanvir.schoolapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mirtanvir.schoolapi.domain.School;
import com.mirtanvir.schoolapi.repositories.SchoolRepository;

@Controller
@RequestMapping("html/**")
public class HtmlController {

	@Autowired
	private SchoolRepository repo;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	
	
	private ModelAndView getAllSchools(Pageable page) {
		return new ModelAndView("WEB-INF/velocity/hello.vm", "schools", repo.findAllSchool());
	}

}