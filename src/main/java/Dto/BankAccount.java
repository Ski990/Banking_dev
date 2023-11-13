package Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class BankAccount {
	@Id
	@SequenceGenerator(initialValue = 45865311,allocationSize = 1,sequenceName = "accno",name = "accno")
	@GeneratedValue(generator = "accno")
	long acc_no;
	String account_type;
	double amount;
	double acc_limit;
	boolean status;
	
	@ManyToOne
	CustomerDto dto;

	

	@OneToMany(cascade = CascadeType.ALL)//directly we can save the data without et.begin(),em.persist(),et.commit.
	List<Transaction>bankTransactions;



	public long getAcc_no() {
		return acc_no;
	}



	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}



	public String getAccount_type() {
		return account_type;
	}



	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public double getAcc_limit() {
		return acc_limit;
	}



	public void setAcc_limit(double acc_limit) {
		this.acc_limit = acc_limit;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	public CustomerDto getDto() {
		return dto;
	}



	public void setDto(CustomerDto dto) {
		this.dto = dto;
	}



	public List<Transaction> getBankTransactions() {
		return bankTransactions;
	}



	public void setBankTransactions(List<Transaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}



	
}
