
<%@include file="header.jsp" %>

<%-- <form:form modelAttribute="brand" action="addbrand">
<form:input path="brandId" type="text" hidden="true" />
<form:input path="brandName" placeholder="Add Brand Name" />
<form:errors path="brandName" />

<input type="Submit" value="Add Brand">

</form:form>--%>


  <div class="container paddingg">
 	<div class="text-center">
 		<a href="category" class="btn btn-danger" role="button">Category Form</a>
		<a href="subcategory" class="btn btn-danger" role="button">SubCategory Form</a>
		<a href="product" class="btn btn-danger" role="button">Product Form</a>
		<a href="brand" class="btn btn-danger" role="button">Brand Form</a>
		
		<a href="supplier" class="btn btn-danger" role="button">Supplier Form</a>						
	</div>
	
		
  	
 		<div class="text-center"><h1>Brand Form</h1></div>
 		<br>
 		
 	<div class="form">
		<form:form modelAttribute="brand" action="addbrand">
			<form:input type="hidden" path="brandId" placeholder="Brand Id" />
			 <div class="row">
		  <div class="col-xs-12 col-sm-4 col-md-4">
		
		  <form:label path="brandName">Please Enter Brand Name</form:label>
		   </div>
		   
		     <div class="col-xs-12 col-sm-4 col-md-4">
			<form:input class="form-control" path="brandName" placeholder="Brand Name" autofocus="true" />		
              	</div>
              		
			    <div class="col-xs-12 col-sm-4 col-md-4">
				<form:errors cssClass="error" path="brandName" />
			</div>
	
		  </div>
		  
		  
		  <br>
	
			
			<div class="row">
		  	<div class="col-sm-12 col-md-12">	
		  		<div class="text-center">	
					<input class="btn btn-success" type="submit" value="${buttonLabel} " />
					<input class="btn btn-danger" type="reset" value="Reset Brand" />
				</div>
				
			</div>
		  </div>		
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
<table class="table table-hover" ng-controller="myController">
	<tr class="info"><th>Brand Id</th>
		<th>Brand Name</th>
		
		<th>Brand Edit</th>
		<th>Brand Delete</th>
	</tr>


	
		<tr class="danger" ng-repeat="bList in myscope | filter:search">
		<td>{{bList.brandId}}</td>
			<td>{{bList.brandName}}</td>
			<td><a href="editbrand-{{bList.brandId}}">EDIT</a></td>
			<td><a href="deletebrand-{{bList.brandId}}">DELETE</a></td>
		</tr>
	

</table>
</div>
</div>
</div>

<script>
var a=angular.module('myApp',[]);
a.controller('myController', function($scope)
{
$scope.myscope= ${brandListByJson}
});
</script> 


<%@ include file="footer.jsp"%>