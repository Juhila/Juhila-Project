<%@include file="header.jsp" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="subCategory" action="addsubcategory">
<form:input path="subCategoryId"  hidden="true" />
<form:input path="subCategoryName" placeholder="Add Subcategory Name" />
<form:errors path="subCategoryName" />
<form:select path="categoryId" items="${categoryList}" itemValue="categoryId" itemLabel="categoryName"/>
<input type="Submit" value="Add SubCategory">
</form:form>
<br><br>

<table  border= "1">
	<tr><th>SubCategory Id</th>
		<th>SubCategory Name</th>
		<th>Category Name</th>
		<th>SubCategory Edit</th>
		<th>SubCategory Delete</th>
	</tr>


	<c:forEach items="${subCategoryList}" var="scList">
		<tr>
		    <td>${scList.subCategoryId}</td>
			<td>${scList.subCategoryName}</td>
			<td>${scList.category.categoryName}</td>
			<td><a href="editsubcategory-${scList.subCategoryId}">EDIT</a></td>
			<td><a href="deletesubcategory-${scList.subCategoryId}">DELETE</a></td>
		</tr>
	</c:forEach>

</table>

<%@ include file="footer.jsp"%>