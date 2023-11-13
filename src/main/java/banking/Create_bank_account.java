package banking;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dao.CustomerDao;
import Dto.BankAccount;
import Dto.CustomerDto;
@WebServlet("/createBankaccount")
public class Create_bank_account extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String banktype=req.getParameter("banktype");
          CustomerDto dto=(CustomerDto) req.getSession().getAttribute("dto");
          List<BankAccount> list1=dto.getList();
          boolean flag=true;
          for (BankAccount bankAccount : list1) {
        	  if(bankAccount.getAccount_type().equals(banktype)) 
        	  {
//        	  if(banktype.equals("savings")||banktype.equals("current")) {
        		  resp.getWriter().print("<h1>account already existed<h1>");
        		  flag=false;
        	  }
			
		}
          if(flag) {
          BankAccount bankAccount=new BankAccount();
          //bankaccount.setAccno(0)---it will genarate automatically
          //bankaccount.setAmount(0)--
          //bankaccount.setstatus(false)
          
          bankAccount.setAccount_type(banktype);
          if(bankAccount.getAccount_type().equals("savings"))
        	  bankAccount.setAcc_limit(10000);
          else 
        	  bankAccount.setAcc_limit(15000);
          
          bankAccount.setDto(dto);
          BankDao bankDao=new BankDao();
          bankDao.save(bankAccount);
          List<BankAccount>list2=list1;//savings
          list2.add(bankAccount);//savings+current
          dto.setList(list2);
          CustomerDao dao=new CustomerDao();
          dao.update(dto);
          resp.getWriter().print("<h1>bankaccount hasbeen created succesfully<h1>"); 
	}
	
}
}
