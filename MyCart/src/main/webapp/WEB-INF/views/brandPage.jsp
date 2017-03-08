
<%@include file="header.jsp" %>

<%-- <form:form modelAttribute="brand" action="addbrand">
<form:input path="brandId" type="text" hidden="true" />
<form:input path="brandName" placeholder="Add Brand Name" />
<form:errors path="brandName" />

<input type="Submit" value="Add Brand">

</form:form>--%>

  <div class="container">
 	<div class="text-center">
 		<a href="category" class="btn btn-info" role="button">Category Form Page</a>
		<a href="subcategory" class="btn btn-info" role="button">SubCategory Form Page</a>
		<a href="product" class="btn btn-info" role="button">Product Form Page</a>
		<a href="supplier" class="btn btn-info" role="button">Supplier Form Page</a>						
	</div>
	
 		<center><h1>Brand Form</h1></center>

 	<div class="form">
		<form:form modelAttribute="brand" action="addbrand">
			<form:input type="hidden" path="brandId" placeholder="Brand Id" />
			 
			<center><div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<form:input class="form-control" path="brandName" placeholder="Brand Name" autofocus="true"/>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">	
					<form:errors cssClass="error" path="brandName" />
				</div>	
			</div></center>
			
			
			<center><div class="row">
		  	<div class="col-sm-12 col-md-12">	
		  		<div class="text-center">	
					<input class="btn btn-success" type="submit" value="Add Brand" />
					<input class="btn btn-danger" type="reset" value="Reset" />
				</div></center>
				
			</div>
		  </div>		
		</form:form>
</div>
</div>
<br><br>
 
<center><table border="1">
	<tr><th>Brand Id</th>
		<th>Brand Name</th>
		
		<th>Brand Edit</th>
		<th>Brand Delete</th>
	</tr>


	<c:forEach items="${brandList}" var="bList">
		<tr>
		<td>${bList.brandId}</td>
			<td>${bList.brandName}</td>
			<td><a href="editbrand-${bList.brandId}">EDIT</a></td>
			<td><a href="deletebrand-${bList.brandId}">DELETE</a></td>
		</tr>
	</c:forEach>

</table></center>




<%@ include file="footer.jsp"%>