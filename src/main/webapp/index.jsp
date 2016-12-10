<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<html>
<body>
<form action="ProcessServlet" method="post" enctype="multipart/form-data">

<br> <br>  <br> 
Select File to Upload:<input type="file" name="fileName" >
<br>  
<input type="submit" value="Upload">
<br> <br>  <br>  

<b>Duplicate Count: </b> ${requestScope.duplicates}<br> 
<b>Unique groups: </b> ${requestScope.unique}<br> 
<b>Frequent Group: </b> ${requestScope.frequent}<br> 
<b>Invalid Groups: </b> ${requestScope.invalid}<br> 
</form>
</body>
</html>
