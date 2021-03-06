<%@ include file="header.jsp" %>
 	
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
      
		
		</div>

<c:if test="${msg eq 'C'}">	
<!--  <div class="container">-->
 
 <div class="text-center"><h1>BILLING ADDRESS</h1></div>
 
 <c:if test="${message eq 0}">
 <center><h4 style="color:blue">(You Can Skip If You Have Already Submitted)</h4></center>
 </c:if>
 
 
 <c:if test="${message eq 1}">
  <center><h4 style="color:blue">(You Cant Skip As You Have Not Submitted It Before)</h4></center>
 </c:if>
 
 <hr style="background-color: red; height: 1px; border: 0;">
 
 
 
 <div class="form">
 
 <form:form modelAttribute="billingAddress" action="addbillingaddress" method="post">
  
<form:input path="billingAddressId"  hidden="true" />

<div class="row">

<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="city">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Your City:</form:label>
 </div>
 
 <div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="city" placeholder="Enter Your City" autofocus="true" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors cssClass="error" path="city" />
</div>
</div>

<br>
<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="state">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Your State</form:label>
 </div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="state" placeholder="Enter Your State" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors cssClass="error" path="state" />
</div>
</div>

<br>
<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="district">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Your District</form:label>
 </div>


<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="district" placeholder="Enter Your District" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors cssClass="error" path="district" />
</div>
</div>

<br>
<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="landmark">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Your LandMark</form:label>
 </div>


<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="landmark" placeholder="Enter Your LandMark" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors  cssClass="error" path="landmark" />
</div>
</div>

<br>
<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="pinCode">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Your Pincode</form:label>
 </div>


<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="pinCode" placeholder="Enter Your Pincode." />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors cssClass="error" path="pinCode" />
</div>
</div>



<br>
<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="address">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Your Address</form:label>
 </div>


<div class="col-xs-12 col-sm-4 col-md-4">

<form:textarea  path="address" cssClass="form-control"  maxlength="255" cols="30" placeholder="Enter Your Full Address" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors cssClass="error" path="address" />
</div>
</div>

<hr style="background-color: red; height: 1px; border: 0;">



<div class="row">
  <div class="col-sm-6 col-md-6">	
  
	&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp	&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp	&nbsp &nbsp &nbsp 
	<div class="text-center">
			&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
			<input class="btn btn-success" type="submit" value="${buttonLabel}" />
			<input class="btn btn-danger" type="reset" value="Reset" />
			
		<!-- 	<c:if test="${msg eq 'PQ'}">
			<a href="shippingaddress-${PRODUCTID}-${QUANTITY}" class="btn btn-info">Skip</a>
			</c:if>-->
			
			
			<a href="confirmorder" class="btn btn-info">Skip</a>
			
			</div>
			 </div>	
		  </div>	
	
</form:form>
	</div>
	<!-- </div>-->
</c:if>
 
	
<c:if test="${msg eq 'PQ'}">
<!-- <div class="container">-->

<div class="text-center"><h1>BILLING ADDRESS</h1></div>
 
 <c:if test="${message eq 0}">
 <center><h4 style="color:blue">(You Can Skip If You Have Already Submitted)</h4></center>
 </c:if>
 
 
 <c:if test="${message eq 1}">
  <center><h4 style="color:blue">(You Cant Skip As You Have Not Submitted It Before)</h4></center>
 </c:if>
 
 <hr style="background-color: red; height: 1px; border: 0;">
 
 
 


 <div class="form">
 <form:form modelAttribute="billingAddress" action="addbillingaddress-${PRODUCTID}-${QUANTITY}" method="post">
 
 <form:input path="billingAddressId"  hidden="true" />

<div class="row">

<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="city">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Your City:</form:label>
 </div>
 
 <div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="city" placeholder="Enter Your City" autofocus="true" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors cssClass="error" path="city" />
</div>
</div>

<br>
<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="state">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Your State</form:label>
 </div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="state" placeholder="Enter Your State" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors cssClass="error" path="state" />
</div>
</div>

<br>
<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="district">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Your District</form:label>
 </div>


<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="district" placeholder="Enter Your District" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors cssClass="error" path="district" />
</div>
</div>

<br>
<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="landmark">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Your LandMark</form:label>
 </div>


<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="landmark" placeholder="Enter Your LandMark" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors  cssClass="error" path="landmark" />
</div>
</div>

<br>
<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="pinCode">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Your Pincode</form:label>
 </div>


<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="pinCode" placeholder="Enter Your Pincode." />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors cssClass="error" path="pinCode" />
</div>
</div>



<br>
<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="address">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Your Address</form:label>
 </div>


<div class="col-xs-12 col-sm-4 col-md-4">

<form:textarea  path="address" cssClass="form-control"  maxlength="255" cols="30" placeholder="Enter Your Full Address" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors cssClass="error" path="address" />
</div>
</div>

<hr style="background-color: red; height: 1px; border: 0;">



<div class="row">
  <div class="col-sm-6 col-md-6">	
  
	&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp	&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp	&nbsp &nbsp &nbsp 
	<div class="text-center">
			&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
			<input class="btn btn-success" type="submit" value="${buttonLabel}" />
			<input class="btn btn-danger" type="reset" value="Reset" />
			
			<c:if test="${msg eq 'PQ'}">
			<a href="confirmorder-${PRODUCTID}-${QUANTITY}" class="btn btn-info">Skip</a>
			</c:if>
			
			
			</div>
			 </div>	
		  </div>	
	
</form:form>
	</div>
	<!-- </div>-->
 
 </c:if>
 

<%@ include file="footer.jsp"%>