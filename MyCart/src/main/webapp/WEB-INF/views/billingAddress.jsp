<%@ include file="header.jsp" %>
 	
	

<div class="container">

 <div class="text-center pad"><h1>BILLING ADDRESS</h1></div>
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
 <form:label path="district">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Your District&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp   &nbsp &nbsp &nbsp &nbsp(email-id)</form:label>
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
 <form:label path="landmark">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Your LandMark &nbsp &nbsp &nbsp  &nbsp &nbsp  &nbsp  &nbsp &nbsp &nbsp  &nbsp  &nbsp &nbsp &nbsp(Min. 8 characters)</form:label>
 </div>


<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="landmark" type="password" placeholder="Enter Your LandMark" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors  cssClass="error" path="landmark" />
</div>
</div>

<br>
<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="pincode">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Your Pincode</form:label>
 </div>


<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="pincode" placeholder="Enter Your Pincode." />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors cssClass="error" path="pincode" />
</div>
</div>




<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="address">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Your Address</form:label>
 </div>


<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="address" placeholder="Enter Your Full Address" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors cssClass="error" path="address" />
</div>
</div>

<hr style="background-color: red; height: 1px; border: 0;">



<div class="row">
  <div class="col-sm-12 col-md-12">	
  
			 <div class="text-center">
			<input class="btn btn-success btn-lg " type="submit" value"${buttonLabel}" />		
			<input class="btn btn-danger btn-lg " type="reset" value="Reset" />
			</div>
			 </div>	
		  </div>	
	
</form:form>
	</div>

<%@ include file="footer.jsp"%>