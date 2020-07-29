package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller //makes this class a Spring controller which allows for request mapping. 
public class StudentController {
	
	@Autowired  //creates an object dependency so that Student is always used
	StudentRepo repo;
	
	
	@RequestMapping("/")   //RequestMapping maps web requests onto specific handler classes & methods
	public String home() {
		
		return "home";
	} 
	
	@RequestMapping("/details")
	public String details(Student student) {
		
		repo.save(student);
		return "home";
	} 
	
	@RequestMapping("/getdetails")
	public String getdetails() {
		
		return "answers";
	} 
	
	
	
	//This portion handles inquiries into the database by student id only
	@PostMapping("/getdetails")  //PostMapping maps HTTP POST requests onto specific handler methods
	public ModelAndView getdetails(@RequestParam int sid ){
		
		ModelAndView mv = new ModelAndView ("retrieve");    
		Student student = repo.findById(sid).orElse(null);
		
		mv.addObject(student);
		return mv;
		
		
	}
	
	
}// end StudentController class
