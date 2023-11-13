package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import Dto.CustomerDto;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
public void save(CustomerDto dto) {
	
	entityTransaction.begin();
	entityManager.persist(dto);
	entityTransaction.commit();
}

public List<CustomerDto> fetch(long mob) {
	List<CustomerDto> list=entityManager.createQuery("select x from CustomerDto x where mobile=?1").setParameter(1, mob).getResultList();
	return list;
}

public List<CustomerDto> fetch(String email) {
	List<CustomerDto> list=entityManager.createQuery("select x from CustomerDto x where email=?1").setParameter(1, email).getResultList();
	return list;
}

 public CustomerDto fetchbyId(long id) {
	 CustomerDto dto= entityManager.find(CustomerDto.class,id);
	 return dto;
 }

public void update(CustomerDto dto) {
	entityTransaction.begin();
	entityManager.merge(dto);
	entityTransaction.commit();
}
}
