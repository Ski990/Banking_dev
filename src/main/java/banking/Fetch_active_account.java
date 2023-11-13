package banking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.BankAccount;
import Dto.CustomerDto;
@WebServlet("/fetchActiveAccount")
public class Fetch_active_account extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerDto dto=(CustomerDto) req.getSession().getAttribute("dto");
		
		List<BankAccount> list=dto.getList();
		
		List<BankAccount>list2=new ArrayList<BankAccount>();
		for (BankAccount bankAccount : list) {
			
			if(bankAccount.isStatus()) {
				list2.add(bankAccount);
			 
			}
			 
		}
		req.getSession().setAttribute("list", list2);
		req.getRequestDispatcher("Account.jsp").include(req, resp);
	}

}
