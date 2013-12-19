<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "java.util.*" %>
    <%@ page import="com.webappspringmvc.PersonRegisterbean" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
System.out.println("MOdify jsp "+ request.getAttribute("keyvalue"));

List<PersonRegisterbean> entry= PersonRegisterbean.getData();
String emailid="",fname="",lname="",country="",uname="";
for(PersonRegisterbean value : entry){
 emailid+=value.getEmailId();
 System.out.println(emailid);
 fname+=value.getFirstName();
 System.out.println(fname);
lname+=value.getLastName();
 country+=value.getCountry();
 uname += value.getUserName();
 
}
System.out.println(emailid);

%>
</body>
<div id="reg">
  <div id="sign">Profile Details</div>
  <form name="register" method="post" action="/update" >
  <table>
  <tr><td>Your FirstName</td><td><input type="text" value="<% fname.toString(); %>" name="fname" onclick="valname()"></td></tr>
   <tr><td>Your LastName</td><td><input type="text" value="<% lname.toString(); %>" name="lname"></td></tr>
    <tr><td>Your Email-Id</td><td><input type="text" value="<% emailid.toString(); %>" name="emailid"></td></tr>
     <tr><td>Enter UserName</td><td><input type="text" value="<% uname.toString(); %>" name="uname" disabled></td></tr>
      <tr><td>Your Password</td><td><input type="password" value=" " name="pwd"></td></tr>
       <tr><td>Your Country</td><td><input type="text" value="" name="country"></td></tr>
       <tr><td colspan="2"><center><input type="submit" value="Register" ></center></td></tr></table>
 </form>
  </div>

</html>