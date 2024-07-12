package com.gvj.spring;

import com.gvj.spring.model.Tutorial;
import com.gvj.spring.repository.TutorialJdbcRepository;
import com.gvj.spring.repository.TutorialJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.io.File;
import java.sql.Connection;
import java.util.Optional;


@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}

	@Autowired
	TutorialJpaRepository jpaRepository;

	@Autowired
	TutorialJdbcRepository jdbcRepository;

	@Override
	public void run(String... args) throws Exception {
		Tutorial tutorial = new Tutorial();
		tutorial.setDescription("description");
		tutorial.setTitle("title");
		tutorial.setPublished(false);

		//create
		//Tutorial _tutorial = jpaRepository.save(tutorial);

		//retrieve
		/*Optional<Tutorial> tuto = jpaRepository.findById(14552L);
		if(tuto.isPresent()) {
			Tutorial _tuto = tuto.get();
			_tuto.setTitle("Java for dummies");
			jpaRepository.save(_tuto);
		}*/

		//update
		//_tutorial.setDescription("Libro de java");
		//_tutorial.setTitle("Java 1");
		//jpaRepository.save(tutorial);

		//delete
		/*
		Optional<Tutorial> tutoToDelete = jpaRepository.findById(14602L);
		if(tutoToDelete.isPresent()) {
			Tutorial _tutoToDelete = tutoToDelete.get();
			jpaRepository.delete(_tutoToDelete);
		}*/


	}

}
