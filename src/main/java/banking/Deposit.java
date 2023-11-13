package banking;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.BankAccount;
import Dto.Transaction;
@WebServlet("/Deposit")
public class Deposit extends HttpServlet 
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String amount=req.getParameter("amount");
	double amt=Double.parseDouble(amount);
	long accno=(long) req.getSession().getAttribute("accno");
	BankDao bankDao=new BankDao();
	BankAccount bankAccount=bankDao.fetch_by_accno(accno);
	bankAccount.setAmount((bankAccount.getAmount()+amt));//before putting any data inside database we should set the data
	bankDao.update(bankAccount);
	Transaction transaction=new Transaction();
	transaction.setBalance(bankAccount.getAmount());
	transaction.setDeposit(amt);
	transaction.setLocalDateTime(LocalDateTime.now());
	transaction.setWithdrow(0);
	
	
	//bankDao.update(bankAccount);
	List<Transaction>list=bankAccount.getBankTransactions();//older previous transaction history
	list.add(transaction);
	
	resp.getWriter().print("<h1>your amonut has been deposit succesfully<h1>");
	req.getRequestDispatcher("transactionPage.jsp").forward(req, resp);
}
}
