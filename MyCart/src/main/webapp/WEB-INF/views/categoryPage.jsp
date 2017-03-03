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

<form:form modelAttribute="category" action="addcategory">
<form:input path="categoryId" type="text" hidden="true" />
<form:input path="categoryName" placeholder="Add category Name" />
<form:input path="categoryDescription" placeholder="Add category Description" />
<input type="Submit" value="Add Category">

</form:form>
<br><br>
<table  border= "1">
	<tr><th>Category Id</th>
		<th>Category Name</th>
		<th>Category Description</th>
		<th>Category Edit</th>
		<th>Category Delete</th>
	</tr>


	<c:forEach items="${categoryList}" var="cList">
		<tr>
		<td>${cList.categoryId}</td>
			<td>${cList.categoryName}</td>
			<td>${cList.categoryDescription}</td>
			<td><a href="editcategory-${cList.categoryId}">EDIT</a></td>
			<td><a href="deletecategory-${cList.categoryId}">DELETE</a></td>
		</tr>
	</c:forEach>

</table>

</body>
</html>