 <%@ include file="header.jsp" %>
 
<%--<div class="container">
  
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="category">Category Form</a></li>
    <li><a data-toggle="tab" href="subcategory">SubCategory Form</a></li>
    <li><a data-toggle="tab" href="product">Product Form</a></li>
    <li><a data-toggle="tab" href="brand">Brand Form</a></li>
    <li><a data-toggle="tab" href="supplier">Supplier Form</a></li>
  </ul>

  <div class="tab-content">
    <div id="category" class="tab-pane fade in active">
    <div id="subcategory" class="tab-pane fade in active">
    <div id="product" class="tab-pane fade in active">
    <div id="brand" class="tab-pane fade in active">
    <div id="supplier" class="tab-pane fade in active">
    
</div>
</div>--%>

<div class="container">
 	<div class="text-center">
 		<a href="category" class="btn btn-info" role="button">Category Form</a>
		<a href="subcategory" class="btn btn-info" role="button">SubCategory Form</a>
		<a href="product" class="btn btn-info" role="button">Product Form</a>
		<a href="brand" class="btn btn-info" role="button">Brand Form</a>
		
		<a href="supplier" class="btn btn-info" role="button">Supplier Form</a>						
	</div>
	
 		<div class="text-center"><h1>Supplier Form</h1></div>
 		



<form:form modelAttribute="supplier" action="addsupplier">

<form:input path="supplierId"  hidden="true" />

<form:input path="supplierName" placeholder="Add Name" />
<form:errors path="supplierName" />


<form:input path="supplierFirmName" placeholder="Add Firm Name" />
<form:errors path="supplierFirmName" />

<form:input path="supplierEmail" placeholder="Add Email" />
<form:errors path="supplierEmail" />

<form:input path="supplierContact" placeholder="Add Mob. No." />
<form:errors path="supplierContact" />

<form:input path="supplierStreet" placeholder="Add Street" />

<form:input path="supplierCity" placeholder="Add City" />

<form:input path="supplierState" placeholder="Add State" />

<form:input path="supplierCountry" placeholder="Add Country" />
<form:errors path="supplierCountry" />

<!--form:input path="isSupplierEnabled" placeholder="Enabled(yes/no)" />-->

<input type="Submit" value="Add Supplier">
</form:form>
<br><br>

<div class="table-responsive">
<table class="table">
	<tr class="info"><th>Supplier Id</th>
		<th>Supplier Name</th>
		<th>Supplier FirmName</th>
		<th>Supplier Email</th>
		<th>Supplier Mobile No.</th>
		<th>Supplier Country</th>
		<th>Edit</th>
		<th>Delete</th>
		</tr>


	<c:forEach items="${supplierList}" var="spList">
		<tr class="danger">
		    <td>${spList.supplierId}</td>
			<td>${spList.supplierName}</td>
			<td>${spList.supplierFirmName}</td>
			<td>${spList.supplierEmail}</td>
			<td>${spList.supplierContact}</td>
			<td>${spList.supplierCountry}</td>
			
			<td><a href="editsupplier-${spList.supplierId}">EDIT</a></td>
			<td><a href="deletesupplier-${spList.supplierId}">DELETE</a></td>
			
		</tr>
	</c:forEach>

</table>
</div>

<%@ include file="footer.jsp"%>