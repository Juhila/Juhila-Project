 <%@ include file="header.jsp" %>
 
 
 <div class="text-center pad"><h1>User Form</h1></div>
 
 <br>
 
 <div class="form">
		<form:form modelAttribute="user" action="adduser">
	
	
	 <div class="text-center">		
	 <form:input type="hidden" path="userId" />
 <div class="row">
		  
	<div class="col-xs-12 col-sm-4 col-md-4">
	 <form:label path="userFirstName"> Enter First Name</form:label>
	 </div>
	 
	 
	 
	 <div class="col-xs-12 col-sm-4 col-md-4">
	 <form:label path="userLastName"> Enter Last Name</form:label>
	 </div>
	
	<div class="col-xs-12 col-sm-4 col-md-4">
	 <form:label path="userContact"> Enter Mobile No</form:label>
	 </div>
	
	 </div>
	 
	 
	 
	 
	 <div class="row">
	 
	 <div class="col-xs-12 col-sm-4 col-md-4">
	<form:input class="form-control" path="userFirstName"  placeholder="First Name" autofocus="true" />		
     </div>
        
        
      <div class="col-xs-12 col-sm-4 col-md-4">
	<form:input class="form-control" path="userLastName"  placeholder="Last Name" autofocus="true" />		
        </div>
         
      <div class="col-xs-12 col-sm-4 col-md-4">
	<form:input class="form-control" path="userContact"  placeholder="Mobile No." autofocus="true" />		
        </div>	
              	
          </div>    		
              		
              		
              		<div class="row">
	 
			    <div class="col-xs-12 col-sm-4 col-md-4">
			    <form:errors cssClass="error" path="userFirstName" />
			    
                     <div class="col-xs-12 col-sm-4 col-md-4">
			    <form:errors cssClass="error" path="userLastName" />
			   
			    <div class="col-xs-12 col-sm-4 col-md-4">
			    <form:errors cssClass="error" path="userContact" />
			   
 
              	</div>
 
 </div>
 </form:form>
 </div>
 
 
 
 
 
 
 
 
<%@ include file="footer.jsp"%>