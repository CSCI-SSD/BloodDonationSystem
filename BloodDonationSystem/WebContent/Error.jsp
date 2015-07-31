


<%@page isErrorPage="true" import="java.io.*" %>
<html>

<head><title>Error Page</title>

</head>
	<body>
		<center>
		
			<img src="'${pageContext.request.contextPath}'/>/imgs/error.jpg" onclick="display_exception();" /><font size="5" color="red">The Resource you have requested doesn't exists!</font>
		</center>
	</body>
	<br>
	
	<div id="exceptionId" style="display:none"><%=exception.toString()%></div>
</html>