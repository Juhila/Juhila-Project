<%@ include file="header.jsp" %>


<div class="container pad">

<div class="row">

<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 well-sm">

 
<form>
 <fieldset>
  <legend align="center">FILTER:</legend>
  
  <div class="dropdown text-center">
   <button class="btn btn-default dropdown-toggle  btn-group-lg btn-danger" type="button" id="menu1" data-toggle="dropdown">SELECT BY BRAND<span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
    
     <c:forEach items="${brandList}" var="bList">
     
      <c:if test="${message eq 0}">
    <center> <li role="presentation"><a role="menuitem" tabindex="-1" href="filterforbrand-${bList.brandId}-${categoryId}">${bList.brandName}</a></li></center>
    </c:if>
    
    <c:if test="${message eq 1}">
    <center> <li role="presentation"><a role="menuitem" tabindex="-1" href="filterforbrande-${bList.brandId}-${subCategoryId}">${bList.brandName}</a></li></center>
    </c:if>
     </c:forEach>
      
   
     </ul>
  </div>
<br>
<br>
<br>
<br>


<!--  
 <div class="dropdown text-center">
    <button class="btn btn-default dropdown-toggle btn-group-lg btn-danger" type="button" id="menu1" data-toggle="dropdown">SELECT BY PRICE<span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
     <c:if test="${message eq 0}">
    <center> <li role="presentation"><a role="menuitem" tabindex="-1" href="filterbyprice-1-categoryId-brandId">1000-10000</a></li></center> 
    
    <center> <li role="presentation"><a role="menuitem" tabindex="-1" href="filterbyprice-2">10001-20000</a></li></center> 
    <center> <li role="presentation"><a role="menuitem" tabindex="-1" href="filterbyprice-3">20002-30000</a></li></center> 
    <center> <li role="presentation"><a role="menuitem" tabindex="-1" href="filterbyprice-4">30001-40000</a></li></center> 
    <center> <li role="presentation"><a role="menuitem" tabindex="-1" href="filterbyprice-5">40001-50000</a></li></center> 
    <center> <li role="presentation"><a role="menuitem" tabindex="-1" href="filterbyprice-6">50001 and Above</a></li></center> 
     
     </ul>
  </div>

<br>
<br>
<br>
<br>

 <div class="dropdown text-center">
    <button class="btn btn-default dropdown-toggle btn-group-lg btn-danger" type="button" id="menu1" data-toggle="dropdown">SELECT BY DISCOUNT PRICE<span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
    <center> <li role="presentation"><a role="menuitem" tabindex="-1" href="filterbydiscountprice-1">0%-10%</a></li></center> 
    <center> <li role="presentation"><a role="menuitem" tabindex="-1" href="filterbydiscountprice-2">11%-20%</a></li></center> 
    <center> <li role="presentation"><a role="menuitem" tabindex="-1" href="filterbydiscountprice-3">21%-30%</a></li></center> 
    <center> <li role="presentation"><a role="menuitem" tabindex="-1" href="filterbydiscountprice-4">31%-40%</a></li></center> 
    <center> <li role="presentation"><a role="menuitem" tabindex="-1" href="filterbydiscountprice-5">41%-50%</a></li></center> 
    <center> <li role="presentation"><a role="menuitem" tabindex="-1" href="filterbydiscountprice-6">51% and Above</a></li></center> 
    
     </ul>
  </div>

  -->

  </fieldset>
 </form>
</div>




<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 well-sm" >



<!--  <div class="row">
 
<input class="form-control" type="text" ng-model="search" placeholder="search" />
 </div>-

<br>

<div class="row">-->
 
  <%--Browsing for products--%>
  <c:forEach items="${ productList}"  var="pList">
  <div class="responsivee">
  <div class="gallery">
    <a href="viewproduct-${pList.productId}" target="_self">
      <img src="resources/images/products/productImage-${pList.productId}.jpg" alt="Trolltunga Norway">
    </a>
    <div class="text-center desc"><h4>${pList.productName}</h4></div>
    
    <div>
    <c:if test="${pList.productDiscountPrice==0}">
    <h4 style="text-align:center">Rs.${pList.productPrice}</h4>
     </c:if>
     
     
     <c:if test="${pList.productDiscountPrice!=0}">
    <h4 style="text-align:left">Rs.${pList.productPrice}</h4>
     </c:if>
     
    <c:if test="${pList.productDiscountPrice!=0}">
    <h4 style="text-align:right">Discount:${pList.productDiscountPrice}%</h4>
     </c:if>
     
    </div>
   
   
  </div>
</div>
</c:forEach>

</div>
 
 </div>		
</div>


<%@ include file="footer.jsp" %>
