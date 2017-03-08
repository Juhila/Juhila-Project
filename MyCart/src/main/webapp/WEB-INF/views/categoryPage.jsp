   
<%@include file="header.jsp" %>
<form:form modelAttribute="category" action="addcategory">
<form:input path="categoryId" type="text" hidden="true" />
<form:input path="categoryName" placeholder="Add category Name" />
<form:errors path="categoryName" />
<form:input path="categoryDescription" placeholder="Add category Description" />
<form:errors path="categoryDescription" />
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

<%@ include file="footer.jsp"%>