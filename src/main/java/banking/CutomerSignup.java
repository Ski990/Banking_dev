package banking;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.jar.Attributes.Name;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CustomerDao;
import Dto.CustomerDto;
@WebServlet("/customerSignup")
public class CutomerSignup extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	String name=req.getParameter("customer");
	String mobile=req.getParameter("moblie");
	String password=req.getParameter("pass");
	String email=req.getParameter("email");
	String gender=req.getParameter("gender");
	String dob=req.getParameter("dob");
	long mob=Long.parseLong(mobile);
	Date date=Date.valueOf(dob);
	Period period=Period.between(date.toLocalDate(),LocalDate.now());
	
	int age=period.getYears();
	if(age>=18) {
		resp.getWriter().print("<h1> person is eligable to create a account </h1>");
		
		
		CustomerDao dao=new CustomerDao();
		List<CustomerDto> list=dao.fetch(mob); 
		List<CustomerDto> list1=dao.fetch(email);
		if(list.isEmpty()&&list1.isEmpty()) {
			CustomerDto dto=new CustomerDto();
			dto.setDob(date);
			dto.setEmail(email); 
		    dto.setMobile(mob);
			dto.setGender(gender);
			dto.setName(name);
			dto.setPwd(password);
			
			dao.save(dto);
//			resp.getWriter().print("<h1>Account hasbeen created succesfully </h1>");
			CustomerDto dto2=dao.fetch(email).get(0);
			long id=dto2.getCustid();
			if(dto2.getGender().equals("male")){
				resp.getWriter().print("<h1>hello sir account has beeen created succesfully </h1>");
				resp.getWriter().print("<h1>your customerid id:"+id+" </h1>");
				req.getRequestDispatcher("Home.html").include(req, resp);
			}
			else {
				resp.getWriter().print("<h1>hahahahah WOMEN </h1>");
				resp.getWriter().print("<h1>your customerid id:"+id+" </h1>");
				req.getRequestDispatcher("Home.html").include(req, resp);
			}
		}
		else {
			resp.getWriter().print("<h1>Account already exist </h1>");
		}
		
	}
	
	else {
		resp.getWriter().print("<h1> person is not eligable to create a account </h1>");
	}
		
}
}
