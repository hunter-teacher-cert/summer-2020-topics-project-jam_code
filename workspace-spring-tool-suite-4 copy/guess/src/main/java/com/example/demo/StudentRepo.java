package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Integer>{
	

}


//This is he data interface for the database. 
//Repository works with the Student class to organize the student details