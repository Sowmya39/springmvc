package mvc_mock;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import mvc_mock.StudentDto;



@Component
public class StudentDao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("abc");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
public void insert(StudentDto e) {
		
		et.begin();
		em.persist(e);
		et.commit();
	}
	
	public List<StudentDto> fetchAll(){
		Query q=em.createQuery("select a  from StudentDto a");
		List<StudentDto> dtos =q.getResultList();
		return dtos;
	}
	public StudentDto fetch(String id){
		StudentDto dto=em.find(StudentDto.class, id);
		return dto;
	}
	public void delete(String id){
		et.begin();
		StudentDto dto=em.find(StudentDto.class, id);
		dto.setId(id);
		em.remove(dto);
		et.commit();
	}
	
}
