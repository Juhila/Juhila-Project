<%@include file="header.jsp" %>

<!--  
<div class="container pad">
<div class="text-center"><h1>Login  Form</h1>
<form class="paddingg" action="perform_login"  method="post">
<input type="text" name="username" placeholder="Add email id as your username"/>


<input type="password" name="password" placeholder="Add password"/>
<input type="submit" value="submit"/>
</form>
</div>
</div>
-->




<div class="container">
   
<div class="row" style="margin-top:60px;margin-bottom:60px">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
    	<form role="form" action="perform_login" method="POST">
			<fieldset>
			
				<center><h2> LOGIN FORM</h2></center>
				<hr style="background-color: red; height: 1px; border: 0;">
				
				
				
				<div class="form-group">
                    <input type="email" name="username" id="email" class="form-control input-lg" placeholder="Enter Email Address As UserName" autofocus="true">
				</div>
				<div class="form-group">
                    <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Enter Password">
				</div>
				
				<hr style="background-color: red; height: 1px; border: 0;">
				
				
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
                        <input type="submit" class="btn btn-lg btn-success btn-block" value="Please Login">
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6">
						<a href="reg-user" class="btn btn-lg btn-danger btn-block">Not Registered Yet?</a>
					</div>
				</div>
			
			</fieldset>
		</form>
	</div>

</div>

</div>

<%@ include file="footer.jsp"%>