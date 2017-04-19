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


 <div class="text-center">
 <h1 class="heading">CONFIRM YOUR ORDER SUMMARY</h1>
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
	
		<!--<c:if test="${FROM eq 'CARTLIST'}">
		<th>Remove Product</th>
		</c:if>-->
		
	</tr>


	 <c:if test="${FROM eq 'CARTLIST'}">
	  <c:forEach items="${orderedlist}" var="C">
		<tr class="danger">
		    
		     
		    <td><a href="viewproduct-${C.productId}"><img src="resources/images/products/productImage-${C.productId}.jpg" height="100px" width="100px" alt="error"/></a></td>
      
			<td>${C.productName}</td>
			
			<td>${C.productPrice}</td>
			<td>${C.productDiscount}</td>
			<td>${C.productQuantity}</td>
			
			<td>${C.amount}</td>
			
		<!-- <td><a href="editbillingaddress">${BILLING.address}</a></td>
			
			
			<td><a href="editshippingaddress">${SHIPPING.address}</a></td>-->
			
			</tr>
			</c:forEach>
			
		<tr class="success" >
	  <th colspan="9"> <center>Total Amount :Rs.${total}</center></th>
	    </tr>
			
		<tr class="info" >
		<th colspan="9"><center><a href="editbillingaddress" class="btn btn-danger">Edit BillingAddress</a>${BILLING.address}</center></th>
		 </tr>
	    
	    <tr class="info" >
	    <th colspan="9"><center><a href="editshippingaddress" class="btn btn-danger">Edit ShippingAddress</a>${SHIPPING.address}</center></th>
	    </tr>
					
		<!-- <td><a href="deletefromconfirmorder-${C.cartItemsId}" class="btn btn-danger btn-lg"><i class="fa fa-trash-o" aria-hidden="true" title="Delete"></a></td>-->
		</c:if>	
			
			
		
			
			
			 <c:if test="${FROM eq 'BUYNOW'}">
			 <tr class="danger">
			  <td><a href="viewproduct-${PRODUCT.productId}"><img src="resources/images/products/productImage-${PRODUCT.productId}.jpg" height="100px" width="100px" alt="error"/></a></td>
			 
			<td>${PRODUCT.productName}</td>
			<td>${PRODUCT.productPrice}</td>
			<td>${PRODUCT.productDiscountPrice}</td>
			<td>${QUANTITY}</td>
			<td>${AMOUNT}</td>
			 
			
			<!-- <td><a href="editbillingaddress-${PRODUCTID}-${QUANTITY}">${BILLING.address}</a></td>
		
			<td><a href="editshippingaddress-${PRODUCTID}-${QUANTITY}" class="btn btn-danger">${SHIPPING.address}</a></td>-->

			</tr>
			
			<tr class="info" >
		<th colspan="9"><center><a href="editbillingaddress-${PRODUCTID}-${QUANTITY}" class="btn btn-danger">Edit BillingAddress</a>${BILLING.address}</center></th>
		 </tr>
	    
	    <tr class="info" >
	    <th colspan="9"><center><a href="editshippingaddress-${PRODUCTID}-${QUANTITY}" class="btn btn-danger">Edit ShippingAddress</a>${SHIPPING.address}</center></th>
	    </tr>
			</c:if>	
			
			
			
</table>
</div>
<div class="padd">

<form>

<div class="row text-center">
<h1 style="color:red">PAYMENT GATEWAY</h1>
<strong>Your Total Amount:</strong> 
 <c:if test="${FROM eq 'BUYNOW'}">
<input type="text" name="text" value="${AMOUNT}" readOnly/>
</c:if>

 <c:if test="${FROM eq 'CARTLIST'}">

 <input type="text" name="text" value="${total}"  readOnly/>
 </c:if>
 	
</div> 

<br>

<div class="row text-center">
 <strong>Select Payment Method:</strong> 
 <select name="payment method">
    <option value="credit" selected>CreditCard</option>
    <option value="debit">DebitCard</option>
    <option value="cash">Cash On Delivery</option>
    <option value="emi">EMI</option>
  </select>
  </div> 
  
  <br><br>
  
  <div class="row text-center"> 
  
   <c:if test="${FROM eq 'CARTLIST'}">
  <a href="payment-${total}" class="btn btn-danger" role="button">Make Payment</a>
  </c:if>
  
   <c:if test="${FROM eq 'BUYNOW'}">
    <a href="payment-${PRODUCT.productId}-${QUANTITY}-${AMOUNT}" class="btn btn-danger" role="button">Make Payment</a>
   </c:if>
   
   </div> 

</form>
</div>

</div>


<%@include file="footer.jsp" %>

	