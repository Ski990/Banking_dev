package Dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class CustomerDto {
@Id
@SequenceGenerator(initialValue = 1122345,allocationSize = 1,sequenceName = "custid",name = "custid")
@GeneratedValue(generator = "custid")
long custid;

String name;
String pwd;
long mobile;
Date dob;
String email;
String gender;
@OneToMany
List<BankAccount> list;
public long getCustid() {
	return custid;
}
public void setCustid(long custid) {
	this.custid = custid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public List<BankAccount> getList() {
	return list;
}
public void setList(List<BankAccount> list) {
	this.list = list;
}



}
