<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- userlist.jsp -->
<title>User List</title>
</head>
<body>
	<%
		out.println("MyBatis List Test");
	%>
	<br>
	<c:forEach var="dto" items="${ users }">
		${dto.student_no} / ${dto.name} / ${dto.age} / ${dto.phone} / ${dto.address} / ${dto.memo}
		<br>
	</c:forEach>

</body>
</html>





