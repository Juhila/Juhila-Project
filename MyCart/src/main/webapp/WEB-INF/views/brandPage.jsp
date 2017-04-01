
<%@include file="header.jsp" %>



  <div class="container paddingg">
 	<div class="text-center">
 		<a href="category" class="btn btn-danger" role="button">Manage Category</a>
		<a href="subcategory" class="btn btn-danger" role="button">Manage SubCategory</a>
		<a href="brand" class="btn btn-danger" role="button">Manage Brand</a>
		<a href="product" class="btn btn-danger" role="button">Manage Product</a>
		
		<a href="supplier" class="btn btn-danger" role="button">Manage Supplier</a>	
		<a href="user" class="btn btn-danger" role="button">Manage User</a>					
	</div>
	
		
  	
 		<div class="text-center"><h1>Manage Brand</h1></div>
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
 		<input class="form-control" type="text" ng-model="search" placeholder="Search" />
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
			<td><a href="editbrand-{{bList.brandId}}"><i class="fa fa-pencil-square-o" aria-hidden="true" title="Edit"></a></td>
			<td><a href="deletebrand-{{bList.brandId}}"><i class="fa fa-trash-o" aria-hidden="true" title="Delete"></a></td>
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