<%@include file="header.jsp" %>
   
  
   
<div class="container paddingg">
 	<div class="text-center">
 		<a href="category" class="btn btn-danger" role="button">Category Form</a>
		<a href="subcategory" class="btn btn-danger" role="button">SubCategory Form</a>
		<a href="product" class="btn btn-danger" role="button">Product Form</a>
		<a href="brand" class="btn btn-danger" role="button">Brand Form</a>
		
		<a href="supplier" class="btn btn-danger" role="button">Supplier Form</a>						
	</div>
	
 		<div class="text-center"><h1>SubCategory Form</h1></div>
 		

<%--<form:form modelAttribute="subCategory" action="addsubcategory">
<form:input path="subCategoryId"  hidden="true" />
<form:input path="subCategoryName" placeholder="Add Subcategory Name" />
<form:errors path="subCategoryName" />
<form:select path="categoryId" items="${categoryList}" itemValue="categoryId" itemLabel="categoryName"/>
<input type="Submit" value="${buttonLabel }">
<input type="Reset" value="Reset SubCategory">
</form:form>--%>


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
			      <form:label path="subCategoryName"> Select SubCategory Name</form:label>
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
<table class="table" ng-controller="myController">

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
			<td><a href="editsubcategory-{{scList.subCategoryId}}">EDIT</a></td>
			<td><a href="deletesubcategory-{{scList.subCategoryId}}">DELETE</a></td>
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