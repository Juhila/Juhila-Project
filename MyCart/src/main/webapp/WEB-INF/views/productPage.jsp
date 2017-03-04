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

<form:form modelAttribute="product" action="addproduct">
<form:input path="productId"  hidden="true" />
<form:input path="productName" placeholder="Add Product Name" />
<form:input path="productPrice" placeholder="Add Product Price" />
<form:input path="productDiscountPrice" placeholder="Add Product Discount Price" />
<form:input path="productStock" placeholder="Add Product Stock" />
<form:input path="productDescription" placeholder="Add Product Description" />
<form:select path="categoryId" items="${categoryList}" itemValue="categoryId" itemLabel="categoryName"/>
<form:select path="subCategoryId" items="${subCategoryList}" itemValue="subCategoryId" itemLabel="subCategoryName"/>
 <form:select path="brandId" items="${brandList}" itemValue="brandId" itemLabel="brandName"/> 
<form:select path="supplierId" items="${supplierList}" itemValue="supplierId" itemLabel="supplierName"/>
<input type="Submit" value="Add Product">
</form:form>
<br><br>

<table border="1">
	<tr><th>Product Id</th>
		<th>Product Name</th>
		<th>Category Name</th>
		<th>SubCategory Name</th>
		<th>Brand Name</th>
		<th>Supplier Name</th>
		<th>Product Price </th>
		<th>Product Discount Price </th>
		<th>Product Stock </th>
		<th>Product Description</th>
		<th> Product Edit</th>
		<th>Product Delete</th>
	</tr>


	<c:forEach items="${productList}" var="pList">
		<tr>
		    <td>${pList.productId}</td>
			<td>${pList.productName}</td>
			<td>${pList.category.categoryName}</td>
			<td>${pList.subCategory.subCategoryName}</td>
			<td>${pList.brand.brandName}</td>
			<td>${pList.supplier.supplierName}</td>
			
			<td>${pList.productPrice}</td>
			<td>${pList.productDiscountPrice}</td>
			<td>${pList.productStock}</td>
			<td>${pList.productDescription}</td>
			<td><a href="editproduct-${pList.productId}">EDIT</a></td>
			<td><a href="deleteproduct-${pList.productId}">DELETE</a></td>
		</tr>
	</c:forEach>

</table>

</body>
</html>