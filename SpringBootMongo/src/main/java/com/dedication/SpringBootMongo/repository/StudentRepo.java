package com.dedication.SpringBootMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dedication.SpringBootMongo.collection.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {

}
