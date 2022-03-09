package com.example.demo;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController
{	
	@Autowired
	PersonnesRepository personsRepo;
	
	@GetMapping("/persons")
	public ModelAndView persons()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("persons", personsRepo.findAll());
		return mav;
	}
	
	@GetMapping("/{id}")
	public String detail(@PathVariable long id, Map<String, Object> model)
	{
		model.put("person", personsRepo.findById(id).get());
		return "detail";
	}
	
//	@GetMapping("/detail")
//	public String detail(@ModelAttribute(value = "person") Person person, Map<String, Object> model)
//	{
//		model.put("person", person);
//		return "detail";
//	}

	@RequestMapping("/create")
	public String create(@ModelAttribute(value="person") Person person, Map<String, Object> model)
	{
		model.put("person", new Person());
		return "create";
	}
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute(value="person") Person person, Map<String, Object> model)
	{
		personsRepo.save(person);
		return "redirect:persons";
	}

	@RequestMapping("/remove")
	public String empDelete(@ModelAttribute(value = "person") Person person, Map<String, Object> model)
	{
		personsRepo.delete(person);
		return "redirect:persons";
	}
}
