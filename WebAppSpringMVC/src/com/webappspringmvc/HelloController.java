package com.webappspringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printwelcome(Model md){
		
		md.addAttribute("message", "Welcome to spring Mvc welord");
		return "hello";
		
	}

}
