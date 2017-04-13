<%@include file="header.jsp" %>

<div class="container pad">
 	<div class="text-center">
 		<a href="wishitems" class="btn btn-danger" role="button">My WishList</a>
		<a href="cartitems" class="btn btn-danger" role="button">My CartList</a>
		<a href="confirmorder" class="btn btn-danger" role="button">Confirm OrderSummary</a>
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
		<th>Product SubTotal </th>
		<th>Edit BillingAddress</th>
		<th>Edit ShippingAddress</th>
		<!--<c:if test="${FROM eq 'CARTLIST'}">
		<th>Remove Product</th>
		</c:if>-->
	</tr>


	 <c:if test="${FROM eq 'CARTLIST'}">
	  <c:forEach items="${cc}" var="CARTITEMS">
		<tr class="danger">
		    
		     
		    <td><a href="viewproduct-${CARTITEMS.productId}"><img src="resources/images/products/productImage-${CARTITEMS.productId}.jpg" height="100px" width="100px" alt="error"/></a></td>
      
			<td>${CARTITEMS.productName}</td>
			
			<td>${CARTITEMS.productPrice}</td>
			<td>${CARTITEMS.productDiscount}</td>
			<td>${CARTITEMS.productQuantity}</td>
			
			<td>${CARTITEMS.amount}</td>
			
			<!--   <c:if test="${msg eq 'PQ'}">
			<td><a href="editbillingaddress-${PRODUCTID}-${QUANTITY}">${BILLING.address}</a></td>
			</c:if>
			-->
			
			
			<td><a href="editbillingaddress">${BILLING.address}</a></td>
			
			
         <!--   <c:if test="${msg eq 'PQ'}">
			<td><a href="editshippingaddress-${PRODUCTID}-${QUANTITY}">${SHIPPING.address}</a></td>
			</c:if>-->
			
			
			<td><a href="editshippingaddress">${SHIPPING.address}</a></td>
			
					
			<!-- <td><a href="deletefromconfirmorder-${CARTITEMS.cartItemsId}" class="btn btn-danger btn-lg"><i class="fa fa-trash-o" aria-hidden="true" title="Delete"></a></td>-->
			
			
			</tr>
			</c:forEach>
					
			</c:if>	
			
			
			
			
			 <c:if test="${FROM eq 'BUYNOW'}">
			 <tr class="danger">
			  <td><a href="viewproduct-${PRODUCT.productId}"><img src="resources/images/products/productImage-${PRODUCT.productId}.jpg" height="100px" width="100px" alt="error"/></a></td>
			 
			<td>${PRODUCT.productName}</td>
			<td>${PRODUCT.productPrice}</td>
			<td>${PRODUCT.productDiscountPrice}</td>
			<td>${QUANTITY}</td>
			<td>${AMOUNT}</td>
			 
			
			<td><a href="editbillingaddress-${PRODUCTID}-${QUANTITY}">${BILLING.address}</a></td>
			
			<!--<c:if test="${msg eq 'C'}">
			<td><a href="editbillingaddress-${CARTITEMSID}">${BILLING.address}</a></td>
			</c:if>-->
			
             
			<td><a href="editshippingaddress-${PRODUCTID}-${QUANTITY}">${SHIPPING.address}</a></td>
			
			
		<!--  	<c:if test="${msg eq 'C'}">
			<td><a href="editshippingaddress-${CARTITEMSID}">${SHIPPING.address}</a></td>
			</c:if>	
			-->
			
			</tr>
			</c:if>	
			
			
			
</table>
</div>
<div class="padd">

<form>

<div class="row text-center">
<h1 style="color:red">PAYMENT GATEWAY</h1>
<strong>Your Total Amount:</strong> 
<input type="text" name="text" readonly/>		
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
  <a href="finalorder" class="btn btn-danger" role="button">Make Payment</a>
   </div> 

</form>
</div>

</div>


<%@include file="footer.jsp" %>

	