package com.MyOwn.MyOwn.EntityRepo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.MyOwn.MyOwn.Entity.Student;

@Repository
public class StudentRepos {

    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Student> findStudentByFirstName(String firstName){
    	CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    	CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Student.class);
    	Root<Student> root=criteriaQuery.from(Student.class);
    	
    	Predicate predicate =criteriaBuilder.equal(root.get("firstName"),firstName);
    	criteriaQuery.where(predicate);
    	
    	TypedQuery<Student> query=entityManager.createQuery(criteriaQuery);
    	return query.getResultList();    }
}
