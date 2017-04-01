 <%@ include file="header.jsp" %>
 
<%--<div class="container">
  
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="category">Category Form</a></li>
    <li><a data-toggle="tab" href="subcategory">SubCategory Form</a></li>
    <li><a data-toggle="tab" href="product">Product Form</a></li>
    <li><a data-toggle="tab" href="brand">Brand Form</a></li>
    <li><a data-toggle="tab" href="supplier">Supplier Form</a></li>
  </ul>

  <div class="tab-content">
    <div id="category" class="tab-pane fade in active">
    <div id="subcategory" class="tab-pane fade in active">
    <div id="product" class="tab-pane fade in active">
    <div id="brand" class="tab-pane fade in active">
    <div id="supplier" class="tab-pane fade in active">
    
</div>
</div>--%>

<div class="container paddingg">
 	<div class="text-center">
 		<a href="category" class="btn btn-danger" role="button">Manage Category</a>
		<a href="subcategory" class="btn btn-danger" role="button">Manage SubCategory</a>
		<a href="brand" class="btn btn-danger" role="button">Manage Brand</a>
		<a href="product" class="btn btn-danger" role="button">Manage Product</a>
		
		<a href="supplier" class="btn btn-danger" role="button">Manage Supplier</a>	
		<a href="user" class="btn btn-danger" role="button">Manage User</a>					
	</div>
	
	
 		

 		<div class="text-center"><h1>Manage Supplier</h1></div>
 		

<br>
 <div class="form">
<form:form modelAttribute="supplier" action="addsupplier">
<form:input path="supplierId"  hidden="true" />

<div class="row">
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="supplierName">Enter Supplier Name</form:label>
 </div>
 
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:input path="supplierName" placeholder="Add Name" autofocus="true"/>
 </div>
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:errors cssClass="error" path="supplierName" />
 </div> 
 </div>
 
 <br>
 
 <div class="row">
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="supplierFirmName">Enter Supplier FirmName</form:label>
 </div>
 
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:input path="supplierFirmName" placeholder="Add FirmName" />
 </div>
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:errors  cssClass="error" path="supplierFirmName" />
 </div>
 </div>
 <br>
 <div class="row">
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="supplierEmail">Enter Supplier Email</form:label>
 </div>
 
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:input path="supplierEmail" placeholder="Add Email" />
 </div>
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:errors  cssClass="error" path="supplierEmail" />
 </div>
 
 </div>
 <br>
 
 <div class="row">
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="supplierContact">Enter Supplier Mobile No.</form:label>
 </div>
 
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:input path="supplierContact" placeholder="Add Mobile No." />
 </div>
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:errors cssClass="error" path="supplierContact" />
 </div>
 </div>
 <br>
 
 
 
 <div class="row">
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="supplierStreet">Enter Supplier Street</form:label>
 </div>
 
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:input path="supplierStreet" placeholder="Add Street" />
 </div>
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:errors cssClass="error" path="supplierStreet" />
 </div>
 
 </div>
 <br>
 
 <div class="row">
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="supplierCity">Enter Supplier City</form:label>
 </div>
 
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:input path="supplierCity" placeholder="Add City" />
 </div>
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:errors  cssClass="error" path="supplierCity" />
 </div>
 </div>
 
 <br>
 <div class="row">
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="supplierState">Enter Supplier State</form:label>
 </div>
 
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:input path="supplierState" placeholder="Add State" />
 </div>
 
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:errors cssClass="error" path="supplierState" />
 </div>
 </div>
 
 <br>
 
 <div class="row">
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="supplierCountry">Enter Supplier Country</form:label>
 </div>
 
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:input path="supplierCountry" placeholder="Add Country" />
 </div>
 
 <div class="col-xs-12 col-sm-4 col-md-4">
 <form:errors cssClass="error" path="supplierCountry" />
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
<table class="table table-hover" ng-controller="myController">
	<tr class="info"><th>Supplier Id</th>
		<th>Supplier  Name</th>
		
		<th>Supplier FirmName</th>
		
		<th>Supplier Email</th>
		<th>Supplier Mobile No.</th>
		<th>Supplier Street</th>
		<th>Supplier City</th>
		<th>Supplier State</th>
		<th>Supplier Country</th>
		<th>Edit</th>
		<th>Delete</th>
		<th>Enable/Disable</th>
		</tr>


		<tr class="danger" ng-repeat="spList in myscope | filter:search">
		    <td>{{spList.supplierId}}</td>
			<td>{{spList.supplierName}}</td>	
			<td>{{spList.supplierFirmName}}</td>
			
			<td>{{spList.supplierEmail}}</td>
			<td>{{spList.supplierContact}}</td>
			<td>{{spList.supplierStreet}}</td>
			<td>{{spList.supplierCity}}</td>
			<td>{{spList.supplierState}}</td>
			<td>{{spList.supplierCountry}}</td>
			
			<td><a href="editsupplier-{{spList.supplierId}}"><i class="fa fa-pencil-square-o" aria-hidden="true" title="Edit"></i>
			</a></td>
			<td><a href="deletesupplier-{{spList.supplierId}}"><i class="fa fa-trash-o" aria-hidden="true" title="Delete"></i></a></td>
			 <td><a href="enablesupplier-{{spList.supplierId}}"><div ng-if="spList.enabled == true">
            <i class="fa fa-toggle-on largetxt" title="Disable"></i>
            </div>
            <div ng-if="spList.enabled != true">
            <i class="fa fa-toggle-off largetxt" title="Enable" ></i>
            </div></a></td>
            
			
		</tr>
	

</table>
</div>
</div>
</div>
</div>
</div>

<script>
var a=angular.module('myApp',[]);
a.controller('myController', function($scope)
{
$scope.myscope= ${supplierListByJson}
});
</script> 


<%@ include file="footer.jsp"%>