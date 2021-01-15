<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"  %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Employee Form</title>
   
</head>
<body>
<%@include file="header.jsp" %>

 <div class="main">
 	<h1>Edit Employee Data</h1>
   		<section class="signup">
		
		
		<spring:form action="${pageContext.request.contextPath}/update" methode="post" modelAttribute="emodel">
		
			<table>
				<tr>
					<td>First Name</td>
					<td><spring:input path="fname"/></td>
				</tr>	
				<tr>
					<td>Last Name</td>
					<td><spring:input path="lname"/></td>
				</tr>	
				<tr>
					<td>Company</td>
					<td><spring:input path="company"/></td>
				</tr>	
				<tr>
			
					<td>Gender</td>
					<td>
						<div class="form-flex">
                                    <input type="radio" name="gender" value="male" id="male" checked="checked" />
                                    <label for="male">Male</label>
    
                                    <input type="radio" name="gender" value="female" id="female" />
                                    <label for="female">Female</label>
                                </div>
					</td>
				</tr>	
				<tr>
					<td>Phone</td>
					<td><spring:input path="phone"/></td>
				</tr>
				<tr>
					<td>DOB</td>
					<td><spring:input path="dob" type="date"/></td>
				</tr>		
				<tr>
					<td>Salary</td>
					<td><spring:input path="salary"/></td>
				</tr>	
				<tr>
					<td>Country</td>
					<td><spring:input path="address.country"/></td>
				</tr>	
				<tr>
					<td>City</td>
					<td><spring:input path="address.city"/></td>
				</tr>	
				<tr>
					<td>State</td>
					<td>
						<spring:select path="address.state">
						 <spring:option value="">---Select---</spring:option>
						  <spring:option value="1">State-1</spring:option>
						  <spring:option value="2">State-2</spring:option>
						  <spring:option value="3">State-3</spring:option>
						  <spring:option value="4">State-4</spring:option>
						  <spring:option value="5">State-5</spring:option>
						  <spring:option value="6">State-6</spring:option>
						  <spring:option value="7">State-7</spring:option>
						</spring:select>
					</td>
				</tr>	
				<tr>
					<td>Zip</td>
					<td><spring:input path="address.zip"/></td>
				</tr>
				<tr>
					<td> <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Update"/>
                        </div></td>
				</tr>		
			
			</table>
			
			<spring:hidden path="id"/>
			<spring:hidden path="address.id"/>
			
		</spring:form>
 </section>
</div>	
	
		
		
		
		<!-- JS -->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery-ui/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery-validation/dist/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery-validation/dist/additional-methods.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>

</body>
</html>