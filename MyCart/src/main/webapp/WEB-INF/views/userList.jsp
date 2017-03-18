

<%@ include file="header.jsp"%>



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
	<tr class="info"><th>User Id</th>
		<th>User First Name</th>
		<th>User Last Name</th>
		<th>User Name(Email)</th>
		<th>User Password</th>
		<th>User Mobile No.</th>
		<th>User Role</th>
		<th>Edit</th>
		<th>Delete</th>
		</tr>


		<tr class="danger" ng-repeat="spList in myscope | filter:search">
		    <td>{{userList.userId}}</td>
			<td>{{userList.userFirstName}}</td>
			<td>{{userList.userLastName}}</td>
			<td>{{userList.userName}}</td>
			<td>{{userList.userPassword}}</td>
			<td>{{spList.userContact}}</td>
			<td>{{spList.userRole}}</td>
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