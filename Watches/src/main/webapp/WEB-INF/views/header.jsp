<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>WATCHES</title>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="jquery-1.8.3.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
	
<style>
body{ padding-top:150px;}
a:hover {background-color: #00008B;
color:#00FFFF}
.navbar .nav > li > a:hover { 
background-color: #00008B;
color:#00FFFF
}
.navbar .nav > li{
color:#00FFFF;
font-family:Verdana;
}
.navbar .nav > li > a{
color:#00FFFF;
font-weight: bold;
font-family:Verdana;
}
.navbar .navbar-brand{
font-size: 20px;
font-style: oblique;
font-weight: bold;
color: #00688B;
}
.dropdown-menu > li > a:hover {
    background-color: #90EE90;
    background-image: none;
}
a.button {
  display: inline-block;
  border-radius: 50%;
  background-color: #3CB371;
  border: 4px solid #00FF7F;
  color: #FFFFFF;
  text-align: center;
  font-size: 20px;
  padding: 20px;
  width: 250px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}
a.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}
a.button span:after {
  content: '»';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

a.button:hover span {
  padding-right: 25px;
}

a.button:hover span:after {
  opacity: 1;
  right: 0;
}
input#button {
background: #3CB371;
color: #fff;
border: 1px solid #00FF7F;
border-radius: 20px;
width:150px;
padding: 10px;
box-shadow: 5px 5px 5px #eee;
transition-duration: 0.4s;
text-decoration: none;
overflow: hidden;
cursor: pointer;
}

input#button:after {
content: "";
    background: #f1f1f1;
    display: block;
    position: absolute;
    padding-top: 300%;
    padding-left: 350%;
    margin-left: -20px !important;
    margin-top: -120%;
    opacity: 0;
    transition: all 0.8s
}

input#button:after {
    padding: 0;
    margin: 0;
    opacity: 1;
    transition: 0s
}

</style>

</head>
<body>

	<nav class="navbar navbar-fixed-top" style="background-color: #3CB371;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="#" class="navbar-brand">WATCHES</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="home">Home</a></li>
					<li><a href="aboutus">About Us</a></li>
					<li><a href="contactus">Contact Us</a></li>
				</ul>
				
				 <ul class="nav navbar-nav navbar-right">
    <c:choose><c:when test="${empty loggedInUser}">
    <li><a href="login">Sign In </a></li>
    <li><a href="signup">Sign Up</a></li></c:when>
    <c:when test="${not empty loggedInUser}">
     
  
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">My Profile <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <li><a href="#">My Account</a></li>
        <li><a href="#">My Orders</a></li>
        <li><a href="#">Settings</a></li>
        <li><a href="logout">Sign Out</a></li>        
       </ul>
       </li>
       <li><a href="#"><span class="glyphicon glyphicon-shopping-cart">Cart</span></a></li></c:when>
       </c:choose>
     
    </ul>   
    </div>   
    </div>
<br>
				<div class="container-fluid">
				
    <ul class="nav navbar-nav navbar-left">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Categories <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <li><a href="images">Item 1</a></li>
        <li><a href="images">Item 2</a></li>
        <li><a href="images">Item 3</a></li>
        <li><a href="images">Item 4</a></li>
        <li><a href="images">Item 5</a></li>
        <li><a href="images">Item 6</a></li>
        <li><a href="images">Item 7</a></li>
        </ul>
       </li>
    </ul>
    <ul> 
     
   <form class = "bs-example bs-example-form" role = "form">
      <div class = "row">
 <div class = "col-lg-6">
            <div class = "input-group">
               <input type = "text" class = "form-control">
               
               <span class = "input-group-btn">
                  <button class = "btn btn-default" type = "button">
                     Go!
                  </button>
               </span>
               
            </div><!-- /input-group -->
         </div><!-- /.col-lg-6 -->
         
      </div><!-- /.row -->
   </form>
   
   </ul>
  <ul class="nav navbar-nav navbar-right">
    <c:choose><c:when test="${not empty loggedInUser}">
   
    <li class="navbar-text" style="font-size:150%;">Welcome ${loggedInUser}!</li>
     <div class="media" style="float:left;">
   <!--  <div class="media-left media-top"> -->
      <img src="images/MI.jpg" class="media-object" style="width:80px">
    <!-- </div> -->
   </div>
    </c:when>
    
    <c:when test="${loggedout==true}">
    <li class="navbar-text" style="font-size:150%;">${logOutMessage}!</li></c:when>
    </c:choose>
    </ul>
       
</div>   
 </nav> 
  