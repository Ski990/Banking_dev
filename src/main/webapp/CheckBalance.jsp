<%@page import="Dto.CustomerDto"%>
<%@page import="Dto.BankAccount"%>
<%@page import="Dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome_to_check_balance_page</h1>

<%
long accno=(long)request.getSession().getAttribute("accno");
 
BankDao bankDao=new BankDao();
BankAccount bankAccount=bankDao.fetch_by_accno(accno);
CustomerDto dto=bankAccount.getDto();

%>
<h1>hello <%=dto.getName() %> your account balance is:<%=bankAccount.getAmount() %></h1>
</body>
</html>