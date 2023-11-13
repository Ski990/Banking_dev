<%@page import="Dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome_ to _Account _creation_ page</h1>

<%CustomerDto dto=(CustomerDto)request.getSession().getAttribute("dto"); %>
<h1>hello:<%= dto.getName() %></h1>
<h1>select bank type</h1>
<form action="createBankaccount" method="post">
<input type="radio" name="banktype" value="savings" required="required">Savings
<input type="radio" name="banktype" value="current" >Current<br><br>
<button>submit</button><button type="reset">Cancel</button>
</form>
</body>
</html>