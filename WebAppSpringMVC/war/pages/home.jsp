<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
#header{
width : 100%;
hieght : 20%;
background-color: #CEE3F6;
text-align : right;
font-size : 150%;
color:#08298A;
}</style>
<title>Home Page</title>
</head>
<body>
<% 
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Experies", 0);

System.out.print(session.getAttribute("uname"));
 if(session.getAttribute("uname") == null){
 response.sendRedirect("/login");
 }
 String keyvalue = request.getParameter("keyvalue");
 System.out.println("Passes value "+request.getAttribute("keyvalue"));
 %><div id="header">
${ uname }



 &nbsp;&nbsp;<a href="/pages/modify.jsp">Modify  </a>&nbsp;&nbsp; <a href="/logout">Logout</a>
</div>
</body>
</html>