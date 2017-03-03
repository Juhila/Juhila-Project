<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@include file="index.jsp" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="brand" action="addbrand">
<form:input path="brandId" type="text" hidden="true" />
<form:input path="brandName" placeholder="Add Brand Name" />
<input type="Submit" value="Add Brand">

</form:form>
<br><br>
<table  border= "1">
	<tr><th>Brand Id</th>
		<th>Brand Name</th>
		
		<th>Brand Edit</th>
		<th>Brand Delete</th>
	</tr>


	<c:forEach items="${brandList}" var="bList">
		<tr>
		<td>${bList.brandId}</td>
			<td>${bList.brandName}</td>
			<td><a href="editbrand-${bList.brandId}">EDIT</a></td>
			<td><a href="deletebrand-${bList.brandId}">DELETE</a></td>
		</tr>
	</c:forEach>

</table>

</body>
</html>