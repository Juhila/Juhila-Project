<%@include file="header.jsp" %>
   
<div class="container">
 	<div class="text-center">
 		<a href="category" class="btn btn-info" role="button">Category Form</a>
		<a href="subcategory" class="btn btn-info" role="button">SubCategory Form</a>
		<a href="product" class="btn btn-info" role="button">Product Form</a>
		<a href="brand" class="btn btn-info" role="button">Brand Form</a>
		
		<a href="supplier" class="btn btn-info" role="button">Supplier Form</a>						
	</div>
	
 		<div class="text-center"><h1>SubCategory Form</h1></div>
 		

<form:form modelAttribute="subCategory" action="addsubcategory">
<form:input path="subCategoryId"  hidden="true" />
<form:input path="subCategoryName" placeholder="Add Subcategory Name" />
<form:errors path="subCategoryName" />
<form:select path="categoryId" items="${categoryList}" itemValue="categoryId" itemLabel="categoryName"/>
<input type="Submit" value="Add SubCategory">
</form:form>
<br><br>

<div class="table-responsive">
<table class="table">

	<tr class="info"><th>SubCategory Id</th>
		<th>SubCategory Name</th>
		<th>Category Name</th>
		<th>SubCategory Edit</th>
		<th>SubCategory Delete</th>
	</tr>


	<c:forEach items="${subCategoryList}" var="scList">
		<tr class="danger">
		    <td>${scList.subCategoryId}</td>
			<td>${scList.subCategoryName}</td>
			<td>${scList.category.categoryName}</td>
			<td><a href="editsubcategory-${scList.subCategoryId}">EDIT</a></td>
			<td><a href="deletesubcategory-${scList.subCategoryId}">DELETE</a></td>
		</tr>
	</c:forEach>

</table>


<%@ include file="footer.jsp"%>