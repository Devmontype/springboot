<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>   
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action='<spring:url value="/signin"/>' method="post">
	    <table>
	      <tr>
	        <td>Username</td>
	        <td><input type="text" name="email"></td>
	      </tr>
	      <tr>
	        <td>Password</td>
	        <td><input type="password" name="password"></td>
	      </tr>
	      <tr>
	        <td><button type="submit">Login</button></td>
	      </tr>
	    </table>
  </form>
  <br/>
  <c:if test="${not empty sessionScope.message}">
    <span style="color:green"><c:out value="${sessionScope.message}"/></span>
    <c:remove var="message" scope="session" />
  </c:if>
</body>
</html>