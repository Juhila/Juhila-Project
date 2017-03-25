<%@include file="header.jsp" %>

<div class="pad"ng-app="myApp">
 <div class="text-center">
 <h1 class="heading">YOUR  CART ITEMS</h1>
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
		<th>Buy Now</th>
		<th>Checkout</th>
		<!-- <th>Add To WishList</th>-->
		<th>View Product</th>
		<th>Remove Product</th>
	</tr>


	
		<tr class="danger" ng-repeat="cartList in myscope | filter:search">
		    <%-- <td><var="src" "value="resources/images/products/productImage-${plist.productId}.jpg" height="100px" width="100px" />
		    <img src="${src}" alt="image not uploaded">
		    </td>--%>
		    <td><img src="resources/images/products/productImage-{{cartList.productId}}.jpg" height="100px" width="100px" alt="error"/></td>

			<td>{{cartList.productName}}</td>
			
			<td>{{cartList.productPrice}}</td>
			<td>{{cartList.productDiscount}}</td>
			<td>{{cartList.productQuantity}}</td>
			
			<td>{{cartList.amount}}</td>
			  <td><a href="buynowfromcartlist-{{cartList.productId}}">BUY NOW</a></td>
			<td><a href="checkoutfromcartlist-{{cartList.cartItemsId}}">CHECKOUT</a></td>
			<!-- <td><a href="addtowishlist-{{cartList.productId}}">ADD TO WISHLIST</a></td>-->
			<td><a href="viewproductfromcartlist-{{cartList.productId}}">VIEW</a></td>
			<td><a href="deletefromcartlist-{{cartList.cartItemsId}}">REMOVE</a></td>
			</tr>

</table>
</div>
</div>
</div>

<script>
var a=angular.module('myApp',[]);
a.controller('myController', function($scope)
{
$scope.myscope= ${cartItemsListByJson}
});
</script> 

<%@ include file="footer.jsp"%>