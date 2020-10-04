<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
<style>
.error{
	color:red;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" action="<spring:url value="/signin"/>" modelAttribute="logUser" >
		<table>
            <tr>
               <td><form:label path = "email">Email</form:label></td>
               <td><form:input path = "email" /></td>
            </tr>
            <tr>
               <td><form:label path = "pswd">Password</form:label></td>
               <td><form:input path = "pswd" /></td>
               <td><form:errors path="pswd" cssClass="error" /></td>
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