<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
	<title><spring:message code="html.register.title"/></title>
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
				<h1><spring:message code="html.register.title"/></h1>
            </header>         
    	<div  class="form">
    		<form id="contactform" action="/BloodDonationSystem/registration.view" method="POST"> 
    			<p class="contact"><label for="name"><spring:message code="html.register.label.firatname" /></label></p> 
    			<input id="firstname" name="firstname" placeholder="First name" required="" tabindex="1" type="text"> 
    			
    			<p class="contact"><label for="name"><spring:message code="html.register.label.lastname" /></label></p> 
    			<input id="lastname" name="lastname" placeholder="Last name" required="" tabindex="2" type="text"> 
    			 
    			<p class="contact"><label for="email"><spring:message code="html.register.label.email" /></label></p> 
    			<input id="email" name="email" placeholder="example@domain.com" required="" type="email"  tabindex="3"> 
               
                <p class="contact"><label for="password"><spring:message code="html.register.label.password" /></label></p> 
    			<input type="password" id="password" name="password" required=""  tabindex="4"> 
                
                <p class="contact"><label for="repassword"><spring:message code="html.register.label.repassword" /></label></p> 
    			<input type="password" id="repassword" name="repassword" required=""  tabindex="5"> 
        
               <fieldset>
                 <label>Birthday</label>
                  <label class="month"> 
	                  <select class="select-style" name="BirthMonth"  tabindex="6">
		                  <option value="">Month</option>
		                  <option  value="01">January</option>
		                  <option value="02">February</option>
		                  <option value="03" >March</option>
		                  <option value="04">April</option>
		                  <option value="05">May</option>
		                  <option value="06">June</option>
		                  <option value="07">July</option>
		                  <option value="08">August</option>
		                  <option value="09">September</option>
		                  <option value="10">October</option>
		                  <option value="11">November</option>
		                  <option value="12" >December</option>
		                </select> 
	                 </label>
                <label>Day<input class="birthday" maxlength="2" name="BirthDay"  placeholder="Day" required=""  tabindex="7"></label>
                <label>Year <input class="birthyear" maxlength="4" name="BirthYear" placeholder="Year" required=""  tabindex="8"></label>
              </fieldset>
  
	            <select class="select-style gender" name="gender"  tabindex="9">
		            <option value="select">i am..</option>
		            <option value="m">Male</option>
		            <option value="f">Female</option>
		            <option value="others">Other</option>
	            </select><br><br>
	            
	            <p class="contact"><label for="name"><spring:message code="html.register.label.add1" /></label></p> 
    			<input id="add1" name="add1" placeholder="Address Line 1" required="" tabindex="10" type="text"> 
    			
    			<p class="contact"><label for="name"><spring:message code="html.register.label.add2" /></label></p> 
    			<input id="add2" name="add2" placeholder="Address Line 2" required="" tabindex="11" type="text"> 
    			
    			<p class="contact"><label for="city"><spring:message code="html.register.label.city" /></label></p> 
    			<input id="city" name="city" placeholder="City" required="" tabindex="12" type="text"> 
    			
    			<p class="contact"><label for="state"><spring:message code="html.register.label.state" /></label></p> 
    			<input id="state" name="state" placeholder="State" required="" tabindex="13" type="text"> 
    			
    			<p class="contact"><label for="zip"><spring:message code="html.register.label.zip" /></label></p> 
    			<input id="zip" name="zip" placeholder="Zip" required="" tabindex="14" type="text"> 
    			
    			<p class="contact"><label for="phone"><spring:message code="html.register.label.phone" /></label></p> 
    			<input id="phone" name="phone" placeholder="Phone number" required="*" tabindex="15" type="text"> 
    			
	            <input  name="pageid" value="donorregistration" type="hidden"> <br>
	            
	            <p class="contact"><label for="ID"><spring:message code="html.register.label.id" /></label></p> 
            	<input id="id" name="id" placeholder="Any photo Id NUmber" required="" type="text" tabindex="16"> <br>
            	
            	 <p class="contact"><label for="phone"><spring:message code="html.register.label.bloodtype" /></label></p> 
            	<input id="bloodtype" name="bloodtype" placeholder="Blood Type" required="" type="text" tabindex="17"> <br>
            	
            	<input class="buttom" name="submit" id="submit" tabindex="18" value="Sign me up!" type="submit"> 	 
   			</form> 
		</div>  
		</div>    
	</body>
</html>
