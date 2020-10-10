<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
<style type="text/css">
.errors {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}
</style>
<script type="text/javascript">
	function validateUserName() {
		var userName = document.getElementById('yn').value;
		if (userName.length < 3) {
			alert("You should have atleast 1 character");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
	<h1 align="center">Love Calculator</h1>
	<hr>
	<form:form action="process-homepage" method="get"
		modelAttribute="Userinfo" onsubmit="return validateUserName()">
		<div align="center">
			<p>
				<label for="yn">Your Name</label>
				<form:input id="yn" path="userName" />
				<form:errors path="userName" cssClass="errors" />
			</p>
			<p>
				<label for="cn">Crush Name</label>
				<form:input id="cn" path="crushName" />
				<form:errors path="crushName" cssClass="errors"/>
				
			</p>
			<p>
				<form:checkbox path="termAndCondition" id="check" />
				<label>I am agreeing that this is for fun</label>
				<form:errors path="termAndCondition" cssClass="errors"/>

			</p>
			<input type="submit" value="Calculate">
		</div>
	</form:form>
</body>
</html>