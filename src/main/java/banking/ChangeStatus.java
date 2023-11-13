package banking;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.BankAccount;
@WebServlet("/changeStatus")
public class ChangeStatus extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acc=req.getParameter("accno");
		long accno=Long.parseLong(acc);
		
		BankDao bankDao=new BankDao();
		BankAccount bankAccount=bankDao.fetch_by_accno(accno);
		if(bankAccount.isStatus()) {
			 bankAccount.setStatus(false);
		}
		else {
			bankAccount.setStatus(true);
			  bankDao.update(bankAccount);
				
				List<BankAccount> list=bankDao.fetchAll_bank_details();
				
				req.getSession().setAttribute("list", list);
				
				req.getRequestDispatcher("Account_home.jsp").include(req, resp);
				
				resp.getWriter().print("<h1>account has been updated");
		}
		
	    
		
	}

}
