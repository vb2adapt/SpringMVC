package com.webappspringmvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class WebAppSpringMVCServlet  {
	@RequestMapping(value ="/signup" , method=RequestMethod.POST)
	public String addperson(HttpServletRequest req,ModelMap model){
		String firstName,lastName,emailId,userName,password,country;
		firstName = req.getParameter("fname");
		lastName = req.getParameter("lname");
		emailId=req.getParameter("emailid");
		userName=req.getParameter("uname");
		password=req.getParameter("pwd");
		country=req.getParameter("country");
		
		PersonRegisterbean.insert(firstName, lastName, emailId, userName, password, country);
		SendEmail.sendMail(emailId, firstName);
		return "login";
		
	}
	
	@RequestMapping(value="/modify/{name}",method=RequestMethod.GET)
	public String update(@PathVariable String name,HttpServletRequest req,ModelMap model){
		
		
		return null;
		
	}
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginperson(HttpServletRequest req, ModelMap model){
		String lgname=req.getParameter("uname");
		String passwd=req.getParameter("pwd");
		String fname,lname,emailid;
		String uname,pwd,returntype = null;
		int flag=0;
		List<PersonRegisterbean> entry= PersonRegisterbean.getData();
		if(entry.isEmpty()){
			returntype="register";
		}
		else{
			for(PersonRegisterbean entrys:entry){
				
				uname=entrys.getUserName();
				pwd=entrys.getPassword();
				
				if(uname.equals(lgname) && pwd.equals(passwd)){
					fname = entrys.getFirstName();
					lname= entrys.getLastName();
					emailid=entrys.getEmailId();
					req.setAttribute("uname", fname+lname);	
					req.setAttribute("keyvalue", lgname);				
					System.out.println("username is "+lgname);
					HttpSession hs=req.getSession();
					hs.setAttribute("uname", uname);					
					flag=1;
					model.addAttribute("uname", fname+lname);
					returntype="home";
					
				}
				
				
			}
			if (flag == 0){
				return returntype="login";
			}
				
		}
		return returntype;
		
		
		
	}
}
