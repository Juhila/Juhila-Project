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
 		<a href="category" class="btn btn-danger" role="button">Category Form</a>
		<a href="subcategory" class="btn btn-danger" role="button">SubCategory Form</a>
		<a href="product" class="btn btn-danger" role="button">Product Form</a>
		<a href="brand" class="btn btn-danger" role="button">Brand Form</a>
		
		<a href="supplier" class="btn btn-danger" role="button">Supplier Form</a>						
	</div>
	
	
 		

 		<div class="text-center"><h1>Supplier Form</h1></div>
 		

<br>
<%-- 
<form:form modelAttribute="supplier" action="addsupplier">

<form:input path="supplierId"  hidden="true" />

<form:input path="supplierName" placeholder="Add Full Name" />
<form:errors path="supplierName" />


<form:input path="supplierFirmName" placeholder="Add Firm Name" />
<form:errors path="supplierFirmName" />


<form:input path="supplierEmail" placeholder="Add Email" />
<form:errors path="supplierEmail" />

<form:input path="supplierContact" placeholder="Add Mob. No." />
<form:errors path="supplierContact" />

<form:input path="supplierStreet" placeholder="Add Street" />

<form:input path="supplierCity" placeholder="Add City" />

<form:input path="supplierState" placeholder="Add State" />

<form:input path="supplierCountry" placeholder="Add Country" />
<form:errors path="supplierCountry" />

<!--form:input path="isSupplierEnabled" placeholder="Enabled(yes/no)" />-->

<input type="Submit" value="${buttonLabel}">
<input type="Reset" value="Reset Supplier">

</form:form>--%>

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
 <form:label path="supplierCountry">Enter Supplier City</form:label>
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
			
			<td><a href="editsupplier-{{spList.supplierId}}">EDIT</a></td>
			<td><a href="deletesupplier-{{spList.supplierId}}">DELETE</a></td>
			
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