package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Index {

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String reindex(HttpServletRequest request, ModelMap model) {
		return "index";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap model) {
		return "index";
	}

}

