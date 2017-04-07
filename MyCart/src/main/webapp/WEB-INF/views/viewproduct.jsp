<%@ include file="header.jsp" %>
<div class="container pad"  ng-app="myApp"  ng-controller="myController">
<div class="row">

<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 well-sm" width="500">

          
         <img width="100%" src="resources/images/products/productImage-{{myscope.productId}}.jpg" alt="COMING SOON"/>
         
          <div class="text-center">
          <br><br><br>
           <strong>Select Quantity:</strong>
           <input type="number" class="form-control" min="1" max="3" value="1" width="20px" ng-model="quantity"/>
          <br>
            <a href="addtowishitems-{{myscope.productId}}-{{quantity}}" class="btn btn-danger btn-lg">
                  <span class="glyphicon glyphicon-heart"></span>Add To Wishlist</a>
                  <c:if test="${viewProduct.productStock!=0}">
                     <a href="addtocartitems-{{myscope.productId}}-{{quantity}}" class="btn btn-danger btn-lg">
                        <span class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</a>
      
        <a href="#" class="btn btn-danger btn-lg">
      <span class="glyphicon glyphicon-check"></span>Buy Now</a>
      </c:if>
      
     </div>
     </div>
     

     
     <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 well-sm" width="500">
<h1 style="color:red;">{{myscope.productName}}</h1>

<h1>Rs.${discprice}</h1>
     
     
  <c:if test="${message==0}">
<h2 style="color:black;">
<span style="text-decoration: line-through;">Rs.{{myscope.productPrice}}</span>&nbsp&nbsp{{myscope.productDiscountPrice}}%OFF</h2>
</c:if>
<br>


<h2>{{myscope.productDescription}}</h3>
<br>
<h3><span style="background-color:orange;">Brand:</span>{{myscope.brand.brandName}}</h3>
<h3><span style="background-color:orange;">Type:</span>{{myscope.subCategory.subCategoryName}}</h3>
<h3><span style="background-color:orange;">Supplier:</span>{{myscope.supplier.supplierName}}</h3>
<h3><span style="background-color:orange;">Stock:</span>{{myscope.productStock}}</h3>


<script>
var a=angular.module('myApp',[]);
a.controller('myController', function($scope)
{
$scope.myscope= ${viewProductByJson};
});
</script> 

<%@ include file="footer.jsp"%>
 