<%@include file="header.jsp" %>

<%@include file="header.jsp" %>

<div class="container pad">
 	<div class="text-center">
 		<a href="wishitems" class="btn btn-danger" role="button">My WishList</a>
		<a href="cartitems" class="btn btn-danger" role="button">My CartList</a>
		
		<c:if test="${FROM eq 'BUYNOW'}">
		<a href="payment-${PRODUCT.productId}-${QUANTITY}-${AMOUNT}" class="btn btn-danger" role="button">fINAL OrderSummary</a>
		</c:if>
		
		<c:if test="${FROM eq 'CARTLIST'}">
		<a href="payment-${total}" class="btn btn-danger" role="button">fINAL OrderSummary</a>
		</c:if>
		
		</div>

<c:if test="${empty finalorderedlist }">
<div class="text-center">
 <h1 class="heading">There are no products in your FINALIST</h1>
</c:if>


<c:if test="${not empty finalorderedlist}">
 <div class="text-center">
 <h1 class="heading">YOUR fINAL ORDER SUMMARY</h1>
 <br>
 

<div class="table-responsive">
<table class="table table-hover">

	<tr class="info">
	    <th>Product Image</th>
	  
		<th>Product Name</th>

		<th>Product Price </th>
		<th>Product Discount Price </th>
		<th>Product Quantity </th>
		<c:if test="${FROM eq 'CARTLIST'}">
		<th>Product SubTotal </th>
		</c:if>
		
		<c:if test="${FROM eq 'BUYNOW'}">
		<th>Product TotalAmount </th>
		</c:if>	
	</tr>


<c:if test="${FROM eq 'CARTLIST'}">
	 <c:forEach items="${finalorderedlist}" var="C">
		<tr class="danger">
		    
		     
		    <td><a href="viewproduct-${C.productId}"><img src="resources/images/products/productImage-${C.productId}.jpg" height="100px" width="100px" alt="error"/></a></td>
      
			<td>${C.productName}</td>
			
			<td>${C.productPrice}</td>
			<td>${C.productDiscount}</td>
			<td>${C.productQuantity}</td>
			
			<td>${C.amount}</td>
		</tr>
	</c:forEach>
			
		<tr class="success" >
	     <th colspan="9"> <center>Total Amount :Rs.${total}</center></th>
	    </tr>
					
	</c:if>	
			
			
	<c:if test="${FROM eq 'BUYNOW'}">
		<tr class="danger">
		   <td><a href="viewproduct-${PRODUCT.productId}"><img src="resources/images/products/productImage-${PRODUCT.productId}.jpg" height="100px" width="100px" alt="error"/></a></td>
			 
			<td>${PRODUCT.productName}</td>
			<td>${PRODUCT.productPrice}</td>
			<td>${PRODUCT.productDiscountPrice}</td>
			<td>${QUANTITY}</td>
			<td>${AMOUNT}</td>
		</tr>
	</c:if>	
	
	</table>
	</div>
  </c:if>   
  </div>  
		
<%@include file="footer.jsp" %>

		