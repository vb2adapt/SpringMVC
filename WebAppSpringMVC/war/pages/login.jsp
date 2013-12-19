<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  body{
    background-color:#FAFAFA;
  }
#body{
margin-top:150px;
margin-left:27%;
font-family:Arial;
border:2px solid black;
border-radius:5%;
width:500px;
height:500px;
    box-shadow:2px 2px 5px ;   
    background-color:#dddddd;
    opacity:1;
}
  
  #inner{
    margin-top:50px ;
      
  }
td{
padding-top:10px;
}

#google{
width:300px;
height:50px;
background-color:#ff0000;
font-family:verdana;
text-align:center;
box-shadow:2px 2px 5px #000000;
border-radius:10px;

}
#Facebook{
width:300px;
height:50px;
background-color:#08088A;
color:#ffffff;
font-family:verdana;
text-align:center;
box-shadow:2px 2px 5px #000000;
border-radius:10px;

}
h2{
text-align:center;
}
a{
text-decoration:none;
color:white;}</style>
</head>
<body>

<form method="post" action="/user/login">
<div id=body>
<center>
  <div id=inner>
<table>
<tr>
<td colspan=2 id="google"><a href="https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email+https://www.googleapis.com/auth/userinfo.profile&state=profile&redirect_uri=http://webappspringmvc.appspot.com/oauth2callback&response_type=code&client_id=128485179938.apps.googleusercontent.com&approval_prompt=auto">Login with Google</a></td>
</tr>
<tr><td></td></tr>
<tr>
<td colspan=2 id="Facebook"><a href="https://www.facebook.com/dialog/oauth?client_id=440221379434612&redirect_uri=http://webappspringmvc.appspot.com/fbauth&scope=email,user_birthday">Login with Facebook</a></td>
</tr></table>
  </br>
<table>
<tr>
<td colspan=2><h2>Login</h2></td>
</tr>
<tr>
<td>Enter your UserName</td>
<td><input type="text" name="uname"></td>
</tr>
<tr>
<td>Enter your Password</td>
<td><input type="password" name="pwd"></td>
<tr>
<td colspan=2><center><input type="submit" value="Login"></center></td>
</tr>
    </table></div>
</center></div>
</form>

</body>
</html>