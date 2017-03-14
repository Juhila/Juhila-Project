   
<%@include file="header.jsp" %>

<%-- <form:form modelAttribute="category" action="addcategory">
<form:input path="categoryId" type="text" hidden="true" />
<form:input path="categoryName" placeholder="Add category Name" />
<form:errors path="categoryName" />
<form:input path="categoryDescription" placeholder="Add category Description" />
<form:errors path="categoryDescription" />
<input type="Submit" value="Add Category">

</form:form>--%>

<%--<div class="container">
 	<div class="text-center">
 		<a href="category" class="btn btn-info" role="button">Category Form Page</a>
		<a href="subcategory" class="btn btn-info" role="button">SubCategory Form Page</a>
		<a href="product" class="btn btn-info" role="button">Product Form Page</a>
		<a href="supplier" class="btn btn-info" role="button">Supplier Form Page</a>						
	</div>--%>
	
<div class="container paddingg">
 	<div class="text-center">
 		<a href="category" class="btn btn-danger" role="button">Category Form</a>
		<a href="subcategory" class="btn btn-danger" role="button">SubCategory Form</a>
		<a href="product" class="btn btn-danger" role="button">Product Form</a>
		<a href="brand" class="btn btn-danger" role="button">Brand Form</a>
		
		<a href="supplier" class="btn btn-danger" role="button">Supplier Form</a>						
	</div>
	
		
		
<div class="text-center">
 		<h1>Category Form</h1>
 	</div>
 	<br>
 	
 
 <div class="form">
 <form:form modelAttribute="category" action="addcategory">
			
			<form:input type="hidden" path="categoryId" />
			
		  <div class="row">
		  <div class="col-xs-12 col-sm-4 col-md-4">
		
		  <form:label path="categoryName"> Enter Category Name</form:label>
		   </div>
		   
		     <div class="col-xs-12 col-sm-4 col-md-4">
			<form:input class="form-control" path="categoryName" placeholder="Category Name" autofocus="true" />		
              	</div>
              		
			    <div class="col-xs-12 col-xs-12 col-sm-4 col-md-4">
				<form:errors cssClass="error" path="categoryName" />
			</div>
	
		  </div>
		  
		  
		  <br>
		  
         
         
         <div class="row">
		  <div class="col-xs-12 col-sm-4 col-md-4">
		
		  <form:label path="categoryDescription">Enter Category Description</form:label>
		   </div>
		   
		     <div class="col-xs-12 col-sm-4 col-md-4">
			<form:input class="form-control" path="categoryDescription" placeholder="Category Description" autofocus="true" />		
              	</div>
              		
			    <div class="col-xs-12 col-sm-4 col-md-4">
				<form:errors cssClass="error" path="categoryDescription" />
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
<table class="table  table-hover " ng-controller="myController">
	<tr class="info"><th>Category Id</th>
		<th>Category Name</th>
		<th>Category Description</th>
		<%--<th>Brand Name</th>--%>
		<th>Category Edit</th>
		<th>Category Delete</th>
	</tr>


	<tr class="danger" ng-repeat="cList in myscope | filter:search">
		    <td>{{cList.categoryId}}</td>
			<td>{{cList.categoryName}}</td>
			<td>{{cList.categoryDescription}}</td>
			<%--<td>{{cList.brand.brandName}}</td>--%>
			<td><a href="editcategory-{{cList.categoryId}}">EDIT</a></td>
			<td><a href="deletecategory-{{cList.categoryId}}">DELETE</a></td>
		</tr>

</table>
</div>
</div>
</div>
</div>
<script>
var a=angular.module('myApp',[]);
a.controller('myController', function($scope)
{
$scope.myscope= ${categoryListByJson}
});
</script> 


<%@ include file="footer.jsp"%>