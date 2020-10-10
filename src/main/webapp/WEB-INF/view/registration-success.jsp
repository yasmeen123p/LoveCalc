<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Your registration is successful</h1>
<h2>The details entered by you are : </h2>
Name : ${userReg.name}<br/>
UserName : ${userReg.userName}<br/>
Password : ${userReg.password}<br/>
CountryName : ${userReg.countryName}<br/>
Hobbies :
	<c:forEach var="temp" items="${userReg.hobbies}">
		${temp}
	
	</c:forEach>
 
 <br/>
Gender : ${userReg.gender}<br/>
Age : ${userReg.age}<br/>

<br/>

Email: ${userReg.communicationDTO.email}<br/>
PhoneNo: ${userReg.communicationDTO.phoneno}
</body>
</html>