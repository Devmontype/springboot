<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.error{
	color:red;
}
</style>
</head>
<body>
<p>${pageContext.request.contextPath}</p>
	<form:form method="post" action="${pageContext.request.contextPath}/empSignup" modelAttribute="emp_user">
		<table>
			<tr>
				<td>Fullname</td>
				<td><form:input path="fullname"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email"/></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><form:select path="authoriti">
						<form:option value="ROLE_USER" label="USER"/>
						<form:option value="ROLE_ADMIN" label="ADMIN"/>
						<form:option value="ROLE_EMPLOYEE" label="EMPLOYEE"/>
				
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Enabled</td>
				<td><form:input path="enabled"/></td>
			</tr>
			<tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
		</table>
	
	</form:form>
</body>
</html>