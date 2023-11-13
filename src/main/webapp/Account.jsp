<%@page import="Dto.BankAccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Account page</h1>
<% List<BankAccount> list=(List<BankAccount>)request.getSession().getAttribute("list");

if(list.isEmpty())
{%>
	<h1>no_active_accounts_found</h1>
<%}
else
{%>
	<%for(BankAccount bankAccount:list)
	{%>
		<a href="setActiveaccont?accno=<%=bankAccount.getAcc_no()%>"><button><%=bankAccount.getAcc_no() %></button></a>
	<% }
		
%>
<%}

%>
</body>
</html>