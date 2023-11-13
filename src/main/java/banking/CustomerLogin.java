package banking;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CustomerDao;
import Dto.CustomerDto;
@WebServlet("/customerLOgin")
public class CustomerLogin extends HttpServlet 
{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
{
	String cusid=req.getParameter("custid");
	String pwd=req.getParameter("pwd");	
	long id=Long.parseLong(cusid);
	
	CustomerDao dao=new CustomerDao();
	CustomerDto dto=dao.fetchbyId(id);
	
	if(dto==null) {
		resp.getWriter().print("<h1>you entered wrong id<h1>");
		req.getRequestDispatcher("CustomerLogin.html").include(req, resp);
	}
	else {
		if(dto.getPwd().equals(pwd)) {
			resp.getWriter().print("<h1>login succesfully<h1>");
			req.getSession().setAttribute("dto", dto);
			req.getRequestDispatcher("CustomerHome.html").include(req, resp);
		}
		else {
			resp.getWriter().print("<h1>you entered wrong password<h1>");
			req.getRequestDispatcher("CustomerLogin.html").include(req, resp);
		}
	}
}
}
