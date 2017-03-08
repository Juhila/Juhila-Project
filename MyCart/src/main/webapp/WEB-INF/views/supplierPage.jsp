 <%@ include file="header.jsp" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="supplier" action="addsupplier">

<form:input path="supplierId"  hidden="true" />

<form:input path="supplierName" placeholder="Add Name" />
<form:errors path="supplierName" />


<form:input path="supplierFirmName" placeholder="Add Firm Name" />
<form:errors path="supplierFirmName" />

<form:input path="supplierEmail" placeholder="Add Email" />
<form:errors path="supplierEmail" />

<form:input path="supplierContact" placeholder="Add Contact No." />
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

<center><table   border= "1">
	<tr><th>Supplier Id</th>
		<th>Supplier Name</th>
		<th>Supplier FirmName</th>
		<th>Supplier Email</th>
		<th>Supplier Contact</th>
		<th>Supplier Country</th>
		<th>Edit</th>
		<th>Delete</th>
		</tr>


	<c:forEach items="${supplierList}" var="spList">
		<tr>
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

</table></center>

<%@ include file="footer.jsp"%>