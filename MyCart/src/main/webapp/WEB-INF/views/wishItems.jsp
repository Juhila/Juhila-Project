<%@include file="header.jsp" %>

<div class="pad"ng-app="myApp">
 <div class="text-center">
 <h1 class="heading">YOUR   WISHLIST</h1>
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
	  
		<th>Product Name</th>

		<th>Product Price </th>
		<th>Product Discount Price </th>
		<th>Product Quantity </th>
		<th>Product SubTotal </th>
		 <th>Add To CartList</th>
		<th>View Product</th>
		<th>Remove Product</th>
	</tr>


	
		<tr class="danger" ng-repeat="wishItemsList in myscope | filter:search">
		    <%-- <td><var="src" "value="resources/images/products/productImage-${plist.productId}.jpg" height="100px" width="100px" />
		    <img src="${src}" alt="image not uploaded">
		    </td>--%>
		    <td><img src="resources/images/products/productImage-{{wishItemsList.productId}}.jpg" height="100px" width="100px" alt="error"/></td>

			<td>{{wishItemsList.productName}}</td>
			
			<td>{{wishItemsList.productPrice}}</td>
			<td>{{wishItemsList.productDiscount}}</td>
			<td>{{wishItemsList.productQuantity}}</td>
			
			<td>{{wishItemsList.amount}}</td>
			   <td><a href="addtowishitems-{{wishItemsList.productId}}-{{1}}">ADD TO WISHLIST</a></td>-->
			<td><a href="viewproduct-{{wishItemsList.productId}}">VIEW</a></td>
			<td><a href="deletefromwishitems-{{wishItemsList.wishItemsId}}">REMOVE</a></td>
			</tr>

</table>
</div>
</div>
</div>

<script>
var a=angular.module('myApp',[]);
a.controller('myController', function($scope)
{
$scope.myscope= ${wishItemsListByJson}
});
</script> 

<%@ include file="footer.jsp"%>