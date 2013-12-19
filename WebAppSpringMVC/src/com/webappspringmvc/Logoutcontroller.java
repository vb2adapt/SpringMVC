package com.webappspringmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout")
public class Logoutcontroller {
@RequestMapping(method=RequestMethod.GET)
	public String clearsession(HttpServletRequest req,ModelMap model){
		
		HttpSession hs1=req.getSession(false);
		
		
		if(hs1 != null){		
		hs1.removeAttribute("uname");
		hs1.invalidate();			
		}
		return "login";
		
	}
}
