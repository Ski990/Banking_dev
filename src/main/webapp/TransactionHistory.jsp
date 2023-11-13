<%@page import="Dto.Transaction"%>
<%@page import="java.util.List"%>
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
<%
long accno=(long)request.getSession().getAttribute("accno");
BankDao bankDao=new BankDao();
BankAccount bankAccount=bankDao.fetch_by_accno(accno);
List<Transaction>list=bankAccount.getBankTransactions();
%>
<h1>Account Number:<%=accno %></h1>
<h1>Account Type:<%=bankAccount.getAccount_type()  %></h1><br>

<table border="1">
<tr>
<th>Transaction_Id</th>
<th>Deposit</th>
<th>Withdrow</th>
<th>Balance</th>
<th>Time</th>
</tr>

<%for(Transaction transaction:list) {%>
<tr>
<th><%=transaction.getTid() %></th>
<th><%=transaction.getDeposit() %></th>
<th><%=transaction.getWithdrow()%></th>
<th><%=transaction.getBalance() %></th>
<th><%=transaction.getLocalDateTime() %></th>


</tr>
<%}%>

</table>
</body>
</html>