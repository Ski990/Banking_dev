package Dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  int Tid;
  double deposit;
  double withdrow;
  double balance;
  LocalDateTime localDateTime;
public int getTid() {
	return Tid;
}
public void setTid(int tid) {
	Tid = tid;
}
public double getDeposit() {
	return deposit;
}
public void setDeposit(double deposit) {
	this.deposit = deposit;
}
public double getWithdrow() {
	return withdrow;
}
public void setWithdrow(double withdrow) {
	this.withdrow = withdrow;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public LocalDateTime getLocalDateTime() {
	return localDateTime;
}
public void setLocalDateTime(LocalDateTime localDateTime) {
	this.localDateTime = localDateTime;
}
  
}
