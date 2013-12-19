<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Hello App Engine</title>
    <script >
    
    function validatEmail(){
    
 var fm=document.forms["register"]["emailid"].value;
var atpo=fm.indexOf("@");
var dotpo=fm.lastIndexOf(".");
if (atpo<1 || dotpo<atpo+2 || dotpo+2>=x.length)
  {
  alert("Not a valid e-mail address");
  return false;
  }
  
    
    }</script>
    <style>
     b{
    background-color: #E0ECF8;
    }
    #reg{
    float:right;
    margin-top:200px;
    margin-right:50px;
    border:3px solid white;
    box-shadow:3px 3px 10px #1C1C1C;
    background-color:#848484;
    
    }
    td{
    padding-top:15px;
    padding-left:10px;
    padding-right:10px;
    color:#FFFFFF;
    font-family:Arial;
    }
    #sign{
    padding-top:30px;
    text-align:center;
    font-family:Arial;
    font-size:30;
    color:white;
    }</style>
    <script type="text/javascript">
    function valname(){
    }</script>
  </head>

  <body>
  
  <div id="reg">
  <div id="sign">Personal Details</div>
  <form name="register" method="post" action="/user/signup" onsubmit="return validatEmail();">
  <table>
  <tr><td>Your FirstName</td><td><input type="text" value="" name="fname" onclick="valname()"></td></tr>
   <tr><td>Your LastName</td><td><input type="text" value="" name="lname"></td></tr>
    <tr><td>Your Email-Id</td><td><input type="text" value="" name="emailid" ></td></tr>
     <tr><td>Enter UserName</td><td><input type="text" value="" name="uname" ></td></tr>
      <tr><td>Your Password</td><td><input type="password" value="" name="pwd"></td></tr>
       <tr><td>Your Country</td><td><input type="text" value="" name="country"></td></tr>
       <tr><td colspan="2"><center><input type="submit" value="Register" ></center></td></tr></table>
 </form>
  </div>
   
  </body>
</html>
