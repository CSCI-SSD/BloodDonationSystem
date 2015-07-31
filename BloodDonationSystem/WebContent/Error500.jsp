<%@page isErrorPage="true" import="java.io.*" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>

<head><title>Error Page</title>

</head>
	<body>
		<center>
			<img src="'${pageContext.request.contextPath}'/>/imgs/error.jpg"  /><font size="5" color="red">There was a problem while servicing your request!</font>
		</center>
	</body>
	<br>
	
	<div id="exceptionId" style="display:none"><%=exception.toString()%></div>
</html>