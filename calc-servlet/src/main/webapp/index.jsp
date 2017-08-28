<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="VarFormulaController?choice=insert" method="post">
		<label>variable name</label><input type="text" name="var_name"/><br>
		<label>formula</label><input type="text" name="formula"/><br>
		<label>variable value</label><input type="text" name="var_value"/><br>
		<label>variable description</label><input type="text" name="var_description"/><br>
		<input type="submit" value="insert"/>
	</form>

</body>
</html>