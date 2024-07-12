package com.gvj.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gvj.spring.model.Tutorial;

import java.util.List;

public interface TutorialJpaRepository extends JpaRepository<Tutorial, Long> {

  List<Tutorial> findByPublished(boolean published);

  List<Tutorial> findByTitleContainingIgnoreCase(String title);
}
