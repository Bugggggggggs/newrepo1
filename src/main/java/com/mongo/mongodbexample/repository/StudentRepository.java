package com.mongo.mongodbexample.repository;

import com.mongo.mongodbexample.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,Integer> {


}

//performing mongodb add below dependency
// ----<dependency>
//			<groupId>org.springframework.boot</groupId>
//			<artifactId>spring-boot-starter-data-mongodb</artifactId>
//		</dependency>
//		<dependency>
//			<groupId>org.springframework.boot</groupId>
//			<artifactId>spring-boot-starter-web</artifactId>
//		</dependency>
