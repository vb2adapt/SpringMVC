package com.webappspringmvc;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/oauth2callback")
public class Googleauth {
 @RequestMapping(method=RequestMethod.GET)
	public String authmethod(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		
		URL url=null;
		HttpURLConnection con=null;		
		String access_token;
		String token_type;
		long expires_in;
		String id_token;
		String auth_code=null;
		try {
		
			System.out.println("Authentication code="+req.getParameter("code"));
			auth_code=req.getParameter("code");
			System.out.println(auth_code);
			String urlvalue= "https://accounts.google.com/o/oauth2/token";
			String param="code="+auth_code+"&redirect_uri=http://webappspringmvc.appspot.com/oauth2callback&client_id=128485179938.apps.googleusercontent.com&scope=&client_secret=wIQtSgN1iA-7rixSQFDBK-ZT&grant_type=authorization_code";
			url = new URL(urlvalue);
			System.out.println(urlvalue);
			con =(HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setDoInput(true);
			con.setDoOutput(true);				
		DataOutputStream dout= new DataOutputStream(con.getOutputStream());
		dout.writeBytes(param);
		dout.flush();
		dout.close();
			BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line;
			StringBuffer response=new StringBuffer();
			while((line = rd.readLine())!=null){
				response.append(line);
				System.out.println(line);
			}
			rd.close();
			System.out.println(response.toString());
			System.out.println(url.getPath());
			System.out.println(con.getResponseMessage());
			
			JSONObject json = new JSONObject();
			JSONParser parse=new JSONParser();
			
				json=(JSONObject) parse.parse(response.toString());
				
				access_token = (String) json.get("access_token");
				System.out.println(access_token);
				token_type = (String) json.get("token_type");
				System.out.println(token_type);
				expires_in =  (long) json.get("expires_in");
				System.out.println(expires_in);
				id_token=(String) json.get("id_token");
				if(!access_token.equals("")){
					String newurlvalue ="https://www.googleapis.com/oauth2/v2/userinfo?token_type="+token_type+"&access_token="+access_token;
			
					url=new URL(newurlvalue);
					con=(HttpURLConnection) url.openConnection();
					con.setRequestMethod("GET");
					BufferedReader rd1 = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String lline;
					StringBuffer rresponse=new StringBuffer();
					while((lline = rd1.readLine())!=null){
						rresponse.append(lline);
						System.out.println(lline);
					}
					rd.close();
					JSONObject json1 = new JSONObject();
					JSONParser parse1=new JSONParser();
					
						json1=(JSONObject) parse1.parse(rresponse.toString());
						
						String email = (String) json1.get("email");
						System.out.println(email);
						String name = (String) json1.get("name");
						System.out.println(name);						
						req.setAttribute("uname", name);
						HttpSession hs=req.getSession();
						hs.setAttribute("uname", name);	
						}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return "home";
		
	}
	
}
