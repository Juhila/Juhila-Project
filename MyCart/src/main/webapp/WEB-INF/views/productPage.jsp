<%@include file="header.jsp" %>
   
<div class="container paddingg">
 	<div class="text-center">
 		<a href="category" class="btn btn-danger" role="button">Category Form</a>
		<a href="subcategory" class="btn btn-danger" role="button">SubCategory Form</a>
		<a href="product" class="btn btn-danger" role="button">Product Form</a>
		<a href="brand" class="btn btn-danger" role="button">Brand Form</a>
		
		<a href="supplier" class="btn btn-danger" role="button">Supplier Form</a>						
	</div>
	
 		<div class="text-center"><h1>Product Form</h1></div>
 		
<br>

<div class="form">
<form:form modelAttribute="product" action="addproduct" enctype="multipart/form-data">
<form:input path="productId"  hidden="true" />


<div class="row">

<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="productName">Enter Product Name</form:label>
 </div>

 <div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="productName" placeholder="Add Product Name" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors  cssClass="error" path="productName" />
</div>

</div>

<br>

<div class="row">

<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="productDescription">Enter Product Description </form:label>
 </div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="productDescription" placeholder="Add Product Description" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors  cssClass="error" path="productDescription" />
</div>

</div>

<br>


<div class="row">

<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="productPrice">Enter Product Price</form:label>
 </div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="productPrice" placeholder="Add Product Price" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors  cssClass="error" path="productPrice" />
</div>

</div>

<br>



<div class="row">

<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="productDiscountPrice">Enter Discount Price </form:label>
 </div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="productDiscountPrice" placeholder="Add Discount Price" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors  cssClass="error"  path="productDiscountPrice" />
</div>

</div>

<br>

<%--<form:input path="productCountry" placeholder="Add Product Country" />
<form:errors path="productCountry" />--%>


<div class="row">

<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="productStock">Enter Stock </form:label>
 </div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="productStock" placeholder="Add Stock" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors  cssClass="error" path="productStock" />
</div>

</div>

<br>

<div class="row">

<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="productImage">Upload product image </form:label>
 </div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="productImage" accept=".jpg,.jpeg,.png" type="file"/>
</div>

</div>

<br>



<div class="row">

<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="categoryId"> Select Category</form:label>
 </div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:select path="categoryId" items="${categoryList}" itemValue="categoryId" itemLabel="categoryName"/>
</div>

</div>
<br>

<div class="row">

<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="subCategoryId"> Select SubCategory</form:label>
 </div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:select path="subCategoryId" items="${subCategoryList}" itemValue="subCategoryId" itemLabel="subCategoryName"/>
</div>

</div>
<br>


<div class="row">

<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="brandId"> Select Brand</form:label>
 </div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:select path="brandId" items="${brandList}" itemValue="brandId" itemLabel="brandName"/>
</div>

</div>
<br>


<div class="row">

<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="supplierId"> Select Supplier</form:label>
 </div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:select path="supplierId" items="${supplierList}" itemValue="supplierId" itemLabel="supplierName"/>
</div>

</div>
<br>



 <div class="row">
	<div class="col-sm-12 col-md-12">	
		<div class="text-center">	
	<input class="btn btn-success" type="submit" value="${buttonLabel}" />
		<input class="btn btn-danger" type="reset" value="Reset Category" />
	</div>
				
      </div>
	</div>	
</form:form>
 </div>

<%-- 
<form:input path="productImage" accept=".jpg,.jpeg,.png" type="file"/>


<form:select path="categoryId" items="${categoryList}" itemValue="categoryId" itemLabel="categoryName"/>
<form:select path="subCategoryId" items="${subCategoryList}" itemValue="subCategoryId" itemLabel="subCategoryName"/>
 <form:select path="brandId" items="${brandList}" itemValue="brandId" itemLabel="brandName"/> 
<form:select path="supplierId" items="${supplierList}" itemValue="supplierId" itemLabel="supplierName"/>
<input type="Submit" value="${buttonLabel }">
<input type="Reset" value="Reset Product">

</form:form>--%>

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
<table class="table table-hover" ng-controller="myController">

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
		    <td><img src="resources/images/products/productImage-${pList.productId}.jpg" height="100px" width="100px" alt="error"/></td>
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