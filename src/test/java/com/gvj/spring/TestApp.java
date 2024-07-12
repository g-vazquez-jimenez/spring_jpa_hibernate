package com.gvj.spring;

import com.gvj.spring.model.Tutorial;
import com.gvj.spring.repository.TutorialJpaRepository;
import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.Optional;

@SpringBootTest
class TestApp {

	@BeforeAll
	public static void initTest() throws SQLException {
		Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082")
				.start();
	}

	@Autowired
    TutorialJpaRepository repository;

	@Test
	void testJPA() {
		Optional<Tutorial> tutorial = repository.findById(1552L);
		if(tutorial.isPresent()) {
			tutorial.get().setTitle("Nuevo dato");
		}
		repository.save(tutorial.get());
	}

	@Test
	void testJdbc() {

	}

}
