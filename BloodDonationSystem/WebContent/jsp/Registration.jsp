<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<jsp:include flush="true" page="include.jsp"></jsp:include>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><spring:message code="html.register.title"/></title>
	</head>
	<body>
		<br>
		<center>
			<table width="50%" class="ui-widget-content" border="0">
				<tr>
					<td>
						<div class="ui-widget-header mainHeader" id="pageHeader" name="pageHeader" width="50%">
							<spring:message code="html.register.title"/>
						</div>
					</td>
				</tr>
			</table>
			
			
			<form name="registrationForm" id="registrationForm" method="POST" >
				<div id="addDiv">		
					<table width="50%"border="0" >
						<tr>
							<td align="left" ><spring:message code="html.register.label.firatname" />:</td>
							<td><input type="text"  name="firstname" id="firstname" maxlength="20" size="20"/></td>
						</tr>
						
						<tr>
							<td align="left"><spring:message code="html.register.label.lastname" />:</td>
							<td><input type="text" name="lastname" id="lastname" maxlength="20" size="20"/></td>
						</tr>
						
						<tr>
							<td align="left"><spring:message code="html.register.label.email" />:</td>
							<td><input type="text" name="email" id="email" maxlength="50" size="30"/></td>
						</tr>
						
						<tr>
							<td align="left"><spring:message code="html.register.label.password" />:</td>
							<td><input type="password" name="password" id="password" maxlength="20" size="20"/></td>
						</tr>
						
						<tr>
							<td align="left"><spring:message code="html.register.label.repassword" />:</td>
							<td><input type="password" name="repassword" id="repassword" maxlength="20" size="20"/></td>
						</tr>
						
						<tr>
							<td align="left"><spring:message code="html.register.label.add1" />:</td>
							<td><input type="text" name="add1" id="add1" maxlength="20" size="50"/></td>
						</tr>
						
						<tr>
							<td align="left"><spring:message code="html.register.label.add2" />:</td>
							<td><input type="text" name="add2" id="add2" maxlength="20" size="50"/></td>
						</tr>
						
						<tr>
							<td align="left"><spring:message code="html.register.label.city" />:</td>
							<td><input type="text" name="city" id="city" maxlength="15" size="50"/></td>
						</tr>
						
						<tr>
							<td align="left"><spring:message code="html.register.label.state" />:</td>
							<td><input type="text" name="state" id="state" maxlength="15" size="50"/></td>
						</tr>
						
						<tr>
							<td align="left"><spring:message code="html.register.label.zip" />:</td>
							<td><input type="text" name="pin" id="pin" maxlength="10" size="50"/></td>
						</tr>
						
						<tr>
							<td align="left"><spring:message code="html.register.label.phone" />:</td>
							<td><input type="text" name="phone" id="phone" maxlength="10" size="50"/></td>
						</tr>
						
						
						<tr>
							<td  align="center" colspan="2">
								<input type="button" name="submit" id="search"  value="<spring:message code="html.global.label.button.register" />" onClick="register();" />
								<input type="submit" name="submit" id="submitButton" value="<spring:message code="html.global.label.button.submit" />"  style="display: none"/>
							</td>
						</tr>
						
					</table>
				</div>
			</form>
			
			
		</center>	
	</body>
</html>