<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!--css-->

<style type="text/css">
.uniq {
	background-color: beige;
}
</style>

<!--javasscrip-->
<script type="text/javascript">
	function loginValidate() {

		alert("javascript calling");

		var user = document.getElementById("uname").value; // find the element

		var pass = document.getElementById("pwd").value;

		//			var aftertrim = user.trim().length;

		if (aftertrim == " ") {
			alert("please enter the username");
			return false;
		}
		if (pass == " ") {
			alert("please enter the password");
			return false;
		}
	}
</script>


</head>

<body class="uniq">
	<h1 align="center" style="background-color: red;">Registration
		Page</h1>

	<p style="background-color: aqua; font-size: xx-large;">Test</p>

	<form action="NewUser" onsubmit="return loginValidate()" method="post">

		<table align="center">
			<tr>
				<td>Username</td>
				<td><input type="text" id="uname" name="user" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" id="pwd" name="pwd" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register" /></td>
			</tr>

		</table>
	</form>
</body>

</html>