   
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
	
	<div class="container">
 	<div class="text-center">
 		<a href="category" class="btn btn-info" role="button">Category Form</a>
		<a href="subcategory" class="btn btn-info" role="button">SubCategory Form</a>
		<a href="product" class="btn btn-info" role="button">Product Form</a>
		<a href="brand" class="btn btn-info" role="button">Brand Form</a>
		
		<a href="supplier" class="btn btn-info" role="button">Supplier Form</a>						
	</div>
	
		
<div class="text-center">
 		<h1>Category Form</h1>
 	</div>
 	<br>
 	
 
 <div class="form">
 <form:form modelAttribute="category" action="addCategory">
			
			<form:input type="hidden" path="categoryId" />
			
		  <div class="row">
		  <div class="col-xs-12 col-sm-6 col-md-6">
		 <div class="text-center">
		  <form:label path="categoryName">Category Name</form:label>
		  </div>
		  </div>
		  </div>
		  
		
		   <div class="row">
		  <div class="col-xs-12 col-sm-6 col-md-6">
		  
				<div class="text-center">
				<center><form:input class="form-control" path="categoryName" placeholder="Category Name" autofocus="true" /></center>		
			</div>
			</div>
			
			
		
			<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="text-center">
				<form:errors cssClass="error" path="categoryName" />
			</div>
			</div>
		  </div>
		  
		  
		  <br>
		  
		  <div class="row">
		  	<div class="col-xs-12 col-sm-6 col-md-6">		
				
			<div class="text-center">
			 <form:label path="categoryName">Category Description</form:label>
		  </div>
		  </div>
		  </div>
		  
		  <div class="row">
			<div class="col-xs-12 col-sm-6 col-md-6">
				<div class="text-center">
				<form:input class="form-control" path="categoryDescription" placeholder="Category Description"  />		
			</div>
			</div>
			
			
			
			
			<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="text-center">
				<form:errors cssClass="error" path="categoryDescription" />
			</div>
			</div>
		  </div>
		  <br>
		
		  <div class="row">
		  	<div class="col-sm-12 col-md-12">	
		  		<div class="text-center">	
					<input class="btn btn-success" type="submit" value="${buttonLabel}" />
					<input class="btn btn-danger" type="reset" value="Reset" />
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
<table class="table" ng-controller="myController">
	<tr class="info"><th>Category Id</th>
		<th>Category Name</th>
		<th>Category Description</th>
		<th>Category Edit</th>
		<th>Category Delete</th>
	</tr>


	<tr class="danger" ng-repeat="cList in myscope | filter:search">
		    <td>{{cList.categoryId}}</td>
			<td>{{cList.categoryName}}</td>
			<td>{{cList.categoryDescription}}</td>
			<td><a href="editcategory-{{cList.categoryId}}">EDIT</a></td>
			<td><a href="deletecategory-{{cList.categoryId}}">DELETE</a></td>
		</tr>

</table>
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