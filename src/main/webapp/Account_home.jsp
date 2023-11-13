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
<h1>Welcome to homne page</h1>
<%List<BankAccount> list=(List<BankAccount> )request.getSession().getAttribute("list"); %>
<table border="1">
<tr>
<th>Account_number</th>
<th>Account_type</th>
<th>Amount</th>
<th>Account_limit</th>
<th>Account_status</th>
<th>Account_name</th>
<th>Customer_id</th>
<th>Change_status</th>
</tr>

<%for(BankAccount bankAccount:list){ %>
<tr>
<th><%=bankAccount.getAcc_no() %></th>
<th><%=bankAccount.getAccount_type() %></th>
<th><%=bankAccount.getAmount() %></th>
<th><%=bankAccount.getAcc_limit() %></th>
<th><%=bankAccount.isStatus() %></th>
<th><%=bankAccount.getDto().getName() %></th>
<th><%=bankAccount.getDto().getCustid() %></th>
<th><a href="changeStatus?accno=<%=bankAccount.getAcc_no() %>"><button>Change_status</button></a></th>
<%} %>
</tr>
</table>
</body>
</html>