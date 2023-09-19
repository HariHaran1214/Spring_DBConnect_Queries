package com.MyOwn.MyOwn.EntityRepo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MyOwn.MyOwn.Entity.Student;

public interface StudentRepo extends JpaRepository<Student,Long>{

	List<Student> findStudentsByFirstName(String firstName);
	
	@Query(value="Select * from Student s where s.last_name=?1",nativeQuery=true)
	List<Student> findByLastName(String lastName);

}
