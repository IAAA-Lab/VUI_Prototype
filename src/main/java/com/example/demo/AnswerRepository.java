package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

interface AnswerRepository extends JpaRepository<Answer, Long> { }
