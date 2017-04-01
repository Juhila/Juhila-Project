<%@ include file="header.jsp" %>
<div class="container pad"  ng-app="myApp"  ng-controller="myController">
<div class="row">

<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 well-sm" width="500">

           
         <img width="100%" src="resources/images/products/productImage-{{myscope.productId}}.jpg" alt="NO IMAGE TO DISPLAY"/>
         
          <div class="text-center">
          
            <a href="addtowishitems-{{myscope.productId}}-{{1}}" class="btn btn-danger btn-lg">
                  <span class="glyphicon glyphicon-heart"></span>Add To Wishlist</a>
                  
                     <a href="addtocartitems-{{myscope.productId}}-{{1}}" class="btn btn-danger btn-lg">
                        <span class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</a>
      
        <a href="#" class="btn btn-danger btn-lg">
      <span class="glyphicon glyphicon-check"></span>Buy Now</a>
      
      </div>
                </div>
         


<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 well-sm" width="500">
<h1 style="color:red;">{{myscope.productName}}</h1>

<h2>Discount:{{myscope.productDiscountPrice}}%</h1>
<span style="text-decoration: line-through;color:red;"><h1 style="color:black;">Rs.{{myscope.productPrice}}</h1></span>
<br>

<h2>{{myscope.productDescription}}</h3>
<br>
<h3>Brand:{{myscope.brand.brandName}}</h3>
<h3>Type:{{myscope.subCategory.subCategoryName}}</h3>
<h3>Supplier:{{myscope.supplier.supplierName}}</h3>
<h3>Stock:{{myscope.productStock}}</h3>


<script>
var a=angular.module('myApp',[]);
a.controller('myController', function($scope)
{
$scope.myscope= ${viewProductByJson};
});
</script> 






<%@ include file="footer.jsp"%>
 