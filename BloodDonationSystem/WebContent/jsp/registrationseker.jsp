\<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
	<title><spring:message code="html.register.seker.title"/></title>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
	    <link rel="stylesheet" type="text/css" href="../css/registration.css" media="all" />
		
    </head>
    <body> 
    	<div class="container">
			<!-- freshdesignweb top bar -->
            <div class="freshdesignweb-top">
             
                <div class="clr"></div>
            </div><!--/ freshdesignweb top bar -->
			<header>
				<h1><spring:message code="html.register.seker.title"/></h1>
            </header>         
    	<div  class="form">
    		<form id="contactform" action="/BloodDonationSystem/registration.view" method="POST"> 
    			<p class="contact"><label for="name"><spring:message code="html.register.label.orgname" /></label></p> 
    			<input id="firstname" name="firstname" placeholder="Organization Name" required="" tabindex="1" type="text"> 
    			 
    			<p class="contact"><label for="email"><spring:message code="html.register.label.email" /></label></p> 
    			<input id="email" name="email" placeholder="example@domain.com" required="" type="email" tabindex="2"> 
               
                <p class="contact"><label for="password"><spring:message code="html.register.label.password" /></label></p> 
    			<input type="password" id="password" name="password" required="" tabindex="3"> 
                
                <p class="contact"><label for="repassword"><spring:message code="html.register.label.repassword" /></label></p> 
    			<input type="password" id="repassword" name="repassword" required="" tabindex="4"> 
        
	            <p class="contact"><label for="name"><spring:message code="html.register.label.add1" /></label></p> 
    			<input id="add1" name="add1" placeholder="Address Line 1" required="" tabindex="5" type="text"> 
    			
    			<p class="contact"><label for="name"><spring:message code="html.register.label.add2" /></label></p> 
    			<input id="add2" name="add2" placeholder="Address Line 2" required="" tabindex="6" type="text"> 
    			
    			<p class="contact"><label for="city"><spring:message code="html.register.label.city" /></label></p> 
    			<input id="city" name="city" placeholder="City" required="" type="text" tabindex="7" > 
    			
    			<p class="contact"><label for="state"><spring:message code="html.register.label.state" /></label></p> 
    			<input id="state" name="state" placeholder="State" required="" tabindex="8" type="text"> 
    			
    			<p class="contact"><label for="zip"><spring:message code="html.register.label.zip" /></label></p> 
    			<input id="zip" name="zip" placeholder="Zip" required=""  type="text" tabindex="9"> 
    			
    			<p class="contact"><label for="phone"><spring:message code="html.register.label.phone" /></label></p> 
    			<input id="phone" name="phone" placeholder="Phone number" required="*" tabindex="10" type="text"> 
	            
	            <p class="contact"><label for="phone"><spring:message code="html.register.label.id" /></label></p> 
            	<input id="id" name="id" placeholder="Organization ID" required="" type="text" tabindex="11"> <br>
            	
            	<input  name="pageid" value="sekerregistration" type="hidden"> <br>
            	
            	<input class="buttom" name="submit" id="submit" tabindex="12" value="Sign me up!" type="submit" onclick="login()"> 	 
   			</form> 
		</div>  
		</div>
		
		<script type="text/javascript">
		
		function login() {
				alert('login');
				var ctx = "${pageContext.request.contextPath}"+"/registration.view";
				document.getElementById("loginForm").action = ctx;
				document.getElementById("submitButton").click();
			
		}
		</script>    
	</body>
</html>
