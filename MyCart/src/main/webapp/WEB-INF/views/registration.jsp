<%@ include file="header.jsp" %>
 	
	

<div class="container">
 <div class="text-center pad"><h1>Registration Form</h1></div>
 
 <br> 
 
 <div class="form">
 <form:form modelAttribute="user" action="reg-adduser" method="post">

<form:input path="userId"  hidden="true" />

<div class="row">

<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="userFirstName">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter First Name</form:label>
 </div>
 
 <div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="userFirstName" placeholder="Add First Name" autofocus="true" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors cssClass="error" path="userFirstName" />
</div>
</div>

<br>
<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="userLastName">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Last Name</form:label>
 </div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="userLastName" placeholder="Add Last Name" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors cssClass="error" path="userLastName" />
</div>
</div>

<br>
<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="username">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter User Name&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp   &nbsp &nbsp &nbsp &nbsp(email-id)</form:label>
 </div>


<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="username" placeholder="Add Email as UserName" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors cssClass="error" path="username" />
</div>
</div>

<br>
<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="password">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Password &nbsp &nbsp &nbsp  &nbsp &nbsp  &nbsp  &nbsp &nbsp &nbsp  &nbsp  &nbsp &nbsp &nbsp(Min. 8 characters)</form:label>
 </div>


<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="password" type="password" placeholder="Add Password" />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors  cssClass="error" path="password" />
</div>
</div>

<br>
<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
 <form:label path="userContact">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Enter Mobile No.</form:label>
 </div>


<div class="col-xs-12 col-sm-4 col-md-4">
<form:input path="userContact" placeholder="Add Mob. No." />
</div>

<div class="col-xs-12 col-sm-4 col-md-4">
<form:errors cssClass="error" path="userContact" />
</div>
</div>
<br>	<br>

<div class="row">
		  	<div class="col-sm-12 col-md-12">	
		  		<div class="text-center">	
					<input class="btn btn-success" type="submit" value"${buttonLabel}" />
					<input class="btn btn-danger" type="reset" value="Reset" />
				</div>
				
			</div>
		  </div>	
		


</form:form>
	</div>
	


	

<%@ include file="footer.jsp"%>