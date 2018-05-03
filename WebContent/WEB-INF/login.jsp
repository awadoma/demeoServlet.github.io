<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form action="start" method="post">
   <label>name </label>
   <input type="text" name="name" id="name"><br>
   <label>password </label>
   <input type="text" name="password" id="password"><br>
   <input type="submit" value="send">
   </form>
   
  <c:forEach var="login" items="${ logins }">
 <c:out value="${userf }"></c:out>
  <ul>
  <li><c:out value="${ login.id }"/><br><c:out value="${ login.name }"/><br><c:out value="${ login.password }"/>
  </ul>
  
  </c:forEach>

   
</body>
</html>