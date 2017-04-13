<%@include file="header.jsp" %>


<div class="container pad">
 	<div class="text-center">
 		<a href="wishitems" class="btn btn-danger" role="button">My WishList</a>
		<a href="cartitems" class="btn btn-danger" role="button">My CartList</a>
		<a href="confirmorder" class="btn btn-danger" role="button">Confirm OrderSummary</a>
		
		</div>

<c:if test="${empty cartItemsListByJson}">
<div class="text-center">
 <h1 class="heading">There are no products in your CARTLIST</h1>
</c:if>

<c:if test="${not empty cartItemsListByJson}">
<div ng-app="myApp">
 <div class="text-center">
 <h1 class="heading">MY  CARTLIST</h1>
 <br>
 
 
 
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
		
		<th>Remove Product</th>
	</tr>


	
		<tr class="danger" ng-repeat="cartItemsList in myscope | filter:search">
		    
		    <td><a href="viewproduct-{{cartItemsList.productId}}"><img src="resources/images/products/productImage-{{cartItemsList.productId}}.jpg" height="100px" width="100px" alt="error"/></a></td>

			<td>{{cartItemsList.productName}}</td>
			
			<td>{{cartItemsList.productPrice}}</td>
			<td>{{cartItemsList.productDiscount}}</td>
			<td>{{cartItemsList.productQuantity}}</td>
			
			<td>{{cartItemsList.amount}}</td>
			
			 
			<!--  <td><a href="billingaddress-{{cartItemsList.cartItemsId}}"  class="btn btn-danger btn-lg"> <span class="glyphicon glyphicon-check" title="CheckOut"></span></a></td>-->
			<!-- <td><a href="addtowishlist-{{cartList.productId}}">ADD TO WISHLIST</a></td>-->
					<td><a href="deletefromcartitems-{{cartItemsList.cartItemsId}}" class="btn btn-danger btn-lg"><i class="fa fa-trash-o" aria-hidden="true" title="Delete"></a></td>
			</tr>
			
			<tr class="info" >
	    <td  colspan="7"><a href="confirmorder" class="btn btn-danger">Checkout</a></td>
	    </tr>
	    

</table>
</div>

</div>
</div>
 </c:if>
</div>

<script>
var a=angular.module('myApp',[]);
a.controller('myController', function($scope)
{
$scope.myscope= ${cartItemsListByJson}
});
</script> 

<%@ include file="footer.jsp"%>