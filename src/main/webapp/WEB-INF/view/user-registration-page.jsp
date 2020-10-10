<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style type="text/css">
.errors {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}
</style>
</head>
<body>
	<h1 align="center">Please Register here</h1>

	<form:form action="registration-success" method="GET"
		modelAttribute="userReg">
		<div align="center">
			<label>Name : </label>
			<form:input path="name" />
			<form:errors path="name" cssClass="errors"/>

			<br /> <label>UserName : </label>
			<form:input path="userName" />
			<form:errors path="userName" cssClass="errors"/>

			<br /> <label>Password : </label>
			<form:password path="password" />

			<br /> <label>Country : </label>
			<form:select path="countryName">
				<form:option value="Ind" label="India"></form:option>
				<form:option value="US" label="United States"></form:option>
				<form:option value="Pak" label="Pakistan"></form:option>
				<form:option value="SL" label="SriLanka"></form:option>
				<form:option value="Aus" label="Australia"></form:option>
			</form:select>

			<br /> <label>Hobbies : </label> Cricket :
			<form:checkbox path="hobbies" value="cricket" />
			Reading :
			<form:checkbox path="hobbies" value="reading" />
			Travel :
			<form:checkbox path="hobbies" value="travel" />
			Badminton :
			<form:checkbox path="hobbies" value="Badminton" />
			Programming :
			<form:checkbox path="hobbies" value="program" />
			Singing :
			<form:checkbox path="hobbies" value="singing" />


			<br /> <label>Gender : </label> Male
			<form:radiobutton path="gender" value="male" />
			Female
			<form:radiobutton path="gender" value="female" />
			<br /> <label>Age : </label>
			<form:input path="age" />
			<form:errors path="age" cssClass="errors" />

			<h3>Communication :</h3>
			<label>Email : </label>
			<form:input path="CommunicationDTO.email" />
			<form:errors path="CommunicationDTO.email" cssClass="errors"/>
			<br />
			<br /> <br />

			<label>PhoneNo : </label>
			<form:input path="communicationDTO.phoneno" />
			<br />
			<br /> <br /> <input type="submit" value="Register">
		</div>

	</form:form>

</body>
</html>