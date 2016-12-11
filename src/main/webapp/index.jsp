<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
</head>
<body>
<form action="Process" method="post" enctype="multipart/form-data">
<h3><b><i>Upload any txt file</i></b></h3>
<br> <br>  <br> 
Select File to Upload:<input type="file" name="fileName" accept="text">
<br>  <br>  
<input type="submit" value="Process">
<br> <br>  <br>  

<b>Duplicate Count: </b> ${requestScope.duplicates}<br> 
<b>Unique groups: </b> ${requestScope.unique}<br> 
<%int k=0;%>
<b>Frequent Group:</b> 
<%List<String> s=(ArrayList)request.getAttribute("frequent");
 if(s!=null){ for(int i=0;i<s.size();i++){ %> <b><%=i+1 %>)</b><%out.print(" "+s.get(i)+" ");}}%>
 <br>
<b>Invalid Groups: </b> 
<%List<String> s1=(ArrayList)request.getAttribute("invalid");
if(s1!=null){ for(k=0;k<s1.size();k++){ %> <b><%=k+1 %>)</b><%out.print(" "+s1.get(k)+" ");}}%>


</form>
</body>
</html>
