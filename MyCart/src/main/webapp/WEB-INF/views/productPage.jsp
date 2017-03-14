<%@include file="header.jsp" %>
   
<div class="container paddingg">
 	<div class="text-center">
 		<a href="category" class="btn btn-info" role="button">Category Form</a>
		<a href="subcategory" class="btn btn-info" role="button">SubCategory Form</a>
		<a href="product" class="btn btn-info" role="button">Product Form</a>
		<a href="brand" class="btn btn-info" role="button">Brand Form</a>
		
		<a href="supplier" class="btn btn-info" role="button">Supplier Form</a>						
	</div>
	
 		<div class="text-center"><h1>Product Form</h1></div>
 		

<form:form modelAttribute="product" action="addproduct" enctype="multipart/form-data">
<form:input path="productId"  hidden="true" />

<form:input path="productName" placeholder="Add Product Name" />
<form:errors path="productName" />

<form:input path="productPrice" placeholder="Add Product Price" />

<form:input path="productDiscountPrice" placeholder="Add Product Discount Price" />


<form:input path="productStock" placeholder="Add Product Stock" />

<%--<form:input path="productCountry" placeholder="Add Product Country" />
<form:errors path="productCountry" />--%>

<form:input path="productImage" accept=".jpg,.jpeg,.png" type="file"/>

<form:input path="productDescription" placeholder="Add Product Description" />
<form:errors path="productDescription" />

<form:select path="categoryId" items="${categoryList}" itemValue="categoryId" itemLabel="categoryName"/>
<form:select path="subCategoryId" items="${subCategoryList}" itemValue="subCategoryId" itemLabel="subCategoryName"/>
 <form:select path="brandId" items="${brandList}" itemValue="brandId" itemLabel="brandName"/> 
<form:select path="supplierId" items="${supplierList}" itemValue="supplierId" itemLabel="supplierName"/>
<input type="Submit" value="${buttonLabel }">
<input type="Reset" value="Reset Product">

</form:form>
<br><br>
<div ng-app="myApp">
 <div class="text-center">
 <div class="row">	
 	<div class="col-xs-12 col-md-4 col-sm-4">	
 		<input class="form-control" type="text" ng-model="search" placeholder="search" />
 	</div>
 </div>
 <br>


<div class="table-responsive">
<table class="table" ng-controller="myController">

	<tr class="info">
	    <th>Product Image</th>
	    <th>Product Id</th>
		<th>Product Name</th>
		<th>Category Name</th>
		<th>SubCategory Name</th>
		<th>Brand Name</th>
		<th>Supplier Name</th>
		<th>Product Price </th>
		<th>Product Discount Price </th>
		<th>Product Stock </th>
		<%--<th>Product Country </th>--%>
		<th>Product Description</th>
		<th> Product Edit</th>
		<th>Product Delete</th>
	</tr>


	
		<tr class="danger" ng-repeat="pList in myscope | filter:search">
		    <%-- <td><var="src" "value="resources/images/products/productImage-${plist.productId}.jpg" height="100px" width="100px" />
		    <img src="${src}" alt="image not uploaded">
		    </td>--%>
		    <td><img src="resources/images/products/productImage-${pList.productId}.jpg" height="100px" width="100px" alt="img not uploaded"/></td>
		    <td>{{pList.productId}}</td>
			<td>{{pList.productName}}</td>
			<td>{{pList.category.categoryName}}</td>
			<td>{{pList.subCategory.subCategoryName}}</td>
			<td>{{pList.brand.brandName}}</td>
			<td>{{pList.supplier.supplierName}}</td>
			
			<td>{{pList.productPrice}}</td>
			<td>{{pList.productDiscountPrice}}</td>
			<td>{{pList.productStock}}</td>
			<%--<td>${pList.productCountry}</td>--%>
			<td>{{pList.productDescription}}</td>
			<td><a href="editproduct-{{pList.productId}}">EDIT</a></td>
			<td><a href="deleteproduct-{{pList.productId}}">DELETE</a></td>
		</tr>

</table>
</div>
</div>
</div>

<script>
var a=angular.module('myApp',[]);
a.controller('myController', function($scope)
{
$scope.myscope= ${productListByJson}
});
</script> 

<%@ include file="footer.jsp"%>