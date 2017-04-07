<%@ include file="header.jsp" %>

<div id="myCarousel"  class=" a carousel slide " data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

    <!-- Wrapper for slides -->
    <div  class="carousel-inner b" role="listbox">
      <div class="item active">
        <img src="http://www.amith.in/magazine/wp-content/uploads/2015/09/Top-5-4G-mobiles-below-15000.jpg" alt="Mobiles" width="460" height="20">
      </div>

      <div class="item">
        <img src="http://www.rentalwala.com/FreeAdImage/Ac-on-Rent-Ac-on-Hire-in-Juhu-Mumbai-4XF8JF3IG13ENU5GSK3C-02-04-2015-516.jpg" alt="Mobiles" width="460" height="20">
      </div>
    
     
      <div class="item">
        <img src="http://www.tvrepairsrus.co.uk/media/slideshow/lcd.jpg" alt="Mobiles" width="460" height="20">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <hr><hr>
  <BR>
  
  <div class="container">
 
  <h1 style="color:red">LATEST TELEVISIONS</h1>
   
  <%--Browsing for products--%>
  
  
    <c:forEach items="${pList}" var="p">
    <div class="responsive">
  <div class="gallery">
 
  
      <a target="_self" href="viewproduct-${p.productId}">
      <img src="resources/images/products/productImage-${p.productId}.jpg" alt="COMING SOON" width="600" height="400">
   </a>
    <div class="desc"><strong>${p.productName}</strong><br>
   <strong> Rs.${p.productPrice}</strong>
   </div>
      
  </div>
 </div>
  </c:forEach> 


  
  
 
  <h1 style="color:red">LEAST PRICE MOBILES</h1>
  </h1>
  
   <c:forEach items="${pLists}" var="p">
  <div class="responsive">
  <div class="gallery">
  
 
     <a target="_self" href="viewproduct-${p.productId}">
      <img src="resources/images/products/productImage-${p.productId}.jpg" alt="COMING SOON" width="600" height="400">
   </a>
    <div class="desc"><strong>${p.productName}</strong><br>
   <strong> Rs.${p.productPrice}</strong>
   </div>
    
  </div>
 </div> 
  </c:forEach> 

  
  
  
  
  <h1 style="color:red">BEST DISCOUNTS ON  REFRIGERATORS</h1>
  
   <c:forEach items="${pListss}" var="p">
  <div class="responsive">
  <div class="gallery">
  
  
     <a target="_self" href="viewproduct-${p.productId}">
      <img src="resources/images/products/productImage-${p.productId}.jpg" alt="COMING SOON" width="600" height="400">
   </a>
     <div class="desc"><strong>${p.productName}</strong><br>
  <strong>  Rs.${p.productPrice}</strong><br>
    
    <c:if test="${p.productDiscountPrice!=0}"><strong>
    ${p.productDiscountPrice}% OFF</strong>
    </c:if>
    
     <c:if test="${p.productDiscountPrice==0}">
    &nbsp&nbsp&nbsp
    </c:if>
   </div>
    
  </div>
 </div>  
  </c:forEach>  


  
  <h1 style="color:red">SUMMER COOL AIRCONDITIONERS</h1>
 
 
  <c:forEach items="${pListsss}" var="p"> 
  <div class="responsive">
  
  <div class="gallery">
  
  
     <a target="_self" href="viewproduct-${p.productId}">
      <img src="resources/images/products/productImage-${p.productId}.jpg" alt="COMING SOON" width="600" height="400">
   </a>
     <div class="desc"><strong>${p.productName}</strong><br>
   <strong> Rs.${p.productPrice}</strong>
   </div>
     
  </div>
  </div> 
  </c:forEach>

  
  </div>
 

<%@ include file="footer.jsp" %>