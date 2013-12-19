package com.webappspringmvc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/fbauth")
public class FbAuthent {
	@RequestMapping(method=RequestMethod.GET)
	public String fbmethod(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		
		URL url = null;
		HttpURLConnection con =null;
		
		try{		
			String fcode= req.getParameter("code");
			System.out.println(fcode);			
			String state = req.getParameter("state");
			System.out.println(state);						
			String accesstoken = getFbAccessToken(fcode);
			String name = getname(accesstoken);			
			model.addAttribute("uname", name);
			HttpSession hs=req.getSession();
			hs.setAttribute("uname", name);			
		
		}
		catch(Exception e){
			System.out.println(e.getStackTrace());
		
	}
		return "home";
		
	}
	private String getname(String accesstoken) {
		// TODO Auto-generated method stub
		String email = null;
		URL url =null;
		URLConnection connection =null;
		String flname =null;
		try{
			if(accesstoken != null & ! "".equals(accesstoken)){
			String newurl = "https://graph.facebook.com/me?" + accesstoken;
			System.out.println(newurl);
			url = new URL(newurl); 
			connection = (URLConnection)url.openConnection();
			
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while((line = rd.readLine()) != null){
				response.append(line);
				System.out.println("Value"+line);
			}
			rd.close();

			System.out.println(connection.getContent());			
			System.out.println("Response string: "+response.toString() );			
			email =response.toString();
			JSONObject json = new JSONObject();
			JSONParser parser = new JSONParser();
			json = (JSONObject) parser.parse(email);
			String fid = (String) json.get("id");
			String fname = (String) json.get("first_name");
			String lname = (String) json.get("last_name");
			email = (String) json.get("email");
			flname=(String) json.get("name");			
			
			System.out.println(fid);
			}
			}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return flname;
	}
	private String getFbAccessToken(String fcode) {
		// TODO Auto-generated method stub
		String token = null;
		if(fcode != null && !"".equals(fcode)){
			String appid = "440221379434612";
			String redirecturl = "http://webappspringmvc.appspot.com/fbauth";
			String fbsecret = "056ab75c6d795abfb5abe5d90c8ef049";
			String newUrl = "https://graph.facebook.com/oauth/access_token?client_id="
                    + appid + "&redirect_uri=" + redirecturl + "&client_secret="
                    + fbsecret + "&code=" + fcode;
			URL url =null;
			HttpURLConnection connection = null;
			try{
			url = new URL(newUrl);
			connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.getOutputStream();
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while((line =rd.readLine()) !=null){
				response.append(line);
			}
			rd.close();
			
			String temp[] = response.toString().split("&");
			System.out.println(token  +  " " + temp[0]);		
			token = temp[0];
				
			
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return token;
	}
}
