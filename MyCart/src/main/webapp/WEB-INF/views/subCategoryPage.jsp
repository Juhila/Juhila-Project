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
	
 		<div class="text-center"><h1>Manage SubCategory</h1></div>
 		

<br>


<div class="form">
		<form:form modelAttribute="subCategory" action="addsubcategory">
			<form:input type="hidden" path="subCategoryId" placeholder="SubCategory Id" />
 <div class="row">
		  
	<div class="col-xs-12 col-sm-4 col-md-4">
	 <form:label path="subCategoryName"> Enter SubCategory Name</form:label>
	 </div>
		   
      <div class="col-xs-12 col-sm-4 col-md-4">
	<form:input class="form-control" path="subCategoryName"  placeholder="SubCategory Name" autofocus="true" />		
        </div>
              		
              		
			    <div class="col-xs-12 col-sm-4 col-md-4">
			    <form:errors cssClass="error" path="subCategoryName" />
			    
			   
			   </div>
			   </div>
			   <br>
			   <div class="row">
			 <div class="col-xs-12 col-sm-4 col-md-4">
			      <form:label path="subCategoryName"> Select Category Name</form:label>
			      </div>
			      
			      <div class="col-xs-12 col-sm-4 col-md-4">
			      <form:select path="categoryId" items="${categoryList}" itemValue="categoryId" itemLabel="categoryName"/>
                   </div>
                    </div>

				<br>
                <div class="row">
		  	<div class="col-sm-12 col-xs-12 col-md-12">	
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
<table class="table table-hover" ng-controller="myController">

	<tr class="info"><th>SubCategory Id</th>
		<th>SubCategory Name</th>
		<th>Category Name</th>
		<th>SubCategory Edit</th>
		<th>SubCategory Delete</th>
	</tr>


		<tr class="danger" ng-repeat="scList in myscope | filter:search">
		    <td>{{scList.subCategoryId}}</td>
			<td>{{scList.subCategoryName}}</td>
			<td>{{scList.category.categoryName}}</td>
			<td><a href="editsubcategory-{{scList.subCategoryId}}" class="btn btn-danger btn-sm"><i class="fa fa-pencil-square-o" aria-hidden="true" title="Edit"></a></td>
			<td><a href="deletesubcategory-{{scList.subCategoryId}}" class="btn btn-danger btn-sm"><i class="fa fa-trash-o" aria-hidden="true" title="Delete"></a></td>
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
$scope.myscope= ${subCategoryListByJson}
});
</script> 



<%@ include file="footer.jsp"%>