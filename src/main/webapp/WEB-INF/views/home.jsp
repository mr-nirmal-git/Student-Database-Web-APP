<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

	<title>Home</title>
</head>
<body>
 
	<c:import url="header.jsp"></c:import>

<h1>Welcome : </h1>  ${user} </P>

<hr>

		<table id="myTable" class="table table-stripted">
			<thead>
				
				<tr class="success">
				
					<td>First Name</td>
					<td>Last Name</td>
					<td>Company</td>
					<td>Gender</td>
					<td>Salary</td>
					<td>Phone</td>
					<td>Country</td>
					<td>Action</td>
				
				</tr>
			
			</thead>
			<tbody>
			
				<c:forEach var="employee" items="${elist}">
				<tr class="danger">
				
					<td>${employee.fname}</td>
					<td>${employee.lname}</td>
					<td>${employee.company}</td>
					<td>${employee.gender}</td>
					<td>${employee.salary}</td>
					<td>${employee.phone}</td>
					<td>${employee.address.country}</td>
					<td>
						<input type="submit" class="btn btn-success" onclick="editEmployee(${employee.id})" value="edit">
						<input type="submit" class="btn-btn-danger" onclick="deleteEmployee(${employee.id})" value="delete">
					</td>	
				</tr>
				</c:forEach>
			
			</tbody>
		</table>
		
		<script type="text/javascript">
		
			function editEmployee(id) {
					
				window.location="${pageContext.request.contextPath}/"+id+"/edit";
					
			}
		
			function deleteEmployee(id) {
				
				var msg = confirm("Do you want to delete?");
				
				if (msg == true){
					window.location="${pageContext.request.contextPath}/"+id+"/delete";
				}
			}
			
			$(document).ready( function () {
			    $('#myTable').DataTable();
			} );
			
		</script>		

</body>
</html>
