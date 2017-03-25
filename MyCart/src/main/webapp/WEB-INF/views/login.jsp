<%@include file="header.jsp" %>


<div class="container pad">
<div class="text-center"><h1>Login  Form</h1>
<form class="paddingg" action="perform_login"  method="post">
<input type="text" name="username" placeholder="Add email id as your username"/>


<input type="password" name="password" placeholder="Add password"/>
<input type="submit" value="submit"/>
</form>
</div>
</div>

<%@ include file="footer.jsp"%>