package banking;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.BankAccount;
@WebServlet("/Adminlogin")
public class AdminLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("AdminMail");
		String password=req.getParameter("pass");
		
		if(email.equals("admin@gmail.com")&&password.equals("admin")) {
			resp.getWriter().print("<h1>login sucessfully<h1>");
			BankDao bankDao=new BankDao();
			List<BankAccount> list=bankDao.fetchAll_bank_details();
			req.getSession().setAttribute("list",list);
			req.getRequestDispatcher("Account_home.jsp").include(req, resp);
		}
		else {
			resp.getWriter().print("<h1>login failed incorrect cradential<h1>");
			req.getRequestDispatcher("Admin.html").include(req, resp);
		}
	}

}
