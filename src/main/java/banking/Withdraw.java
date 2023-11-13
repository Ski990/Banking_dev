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
@WebServlet("/withdrow")
public class Withdraw extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String amount=req.getParameter("amount");
		double amt=Double.parseDouble(amount);
		long accno=(long) req.getSession().getAttribute("accno");
		BankDao bankDao=new BankDao();
		BankAccount bankAccount=bankDao.fetch_by_accno(accno);
		if(bankAccount.getAmount()<amt) {
			resp.getWriter().print("<h1>insification balance<h1>");
		}
		else {
			if(amt>bankAccount.getAcc_limit()){
				resp.getWriter().print("<h1>your account limit is exceeding.your actual amount is:<h1>"+bankAccount.getAcc_limit());
			}
			else {
				bankAccount.setAmount((bankAccount.getAmount()-amt));//before putting any data inside database we should set the data
				Transaction transaction=new Transaction();
				transaction.setBalance(bankAccount.getAmount());
				transaction.setDeposit(0);
				transaction.setLocalDateTime(LocalDateTime.now());
				transaction.setWithdrow(amt);
				
				
				bankDao.update(bankAccount);
				List<Transaction>list=bankAccount.getBankTransactions();//older previous transaction history
				list.add(transaction);
				bankDao.update(bankAccount);
				resp.getWriter().print("your amonut has been withdraw succesfully");
				req.getRequestDispatcher("transactionPage.jsp").forward(req, resp);
			}
		}
		
	}

}
