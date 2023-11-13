package banking;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/setActiveaccont")
public class SetActiveaccount extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String acn=req.getParameter("accno");
		long accno=Long.parseLong(acn);
		req.getSession().setAttribute("accno", accno);//here i can tell account has been set for further opertion
		req.getRequestDispatcher("transactionPage.jsp").include(req, resp);
	}

}
