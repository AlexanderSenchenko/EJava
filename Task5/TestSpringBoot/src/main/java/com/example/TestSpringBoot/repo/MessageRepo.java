package com.example.TestSpringBoot.repo;

import com.example.TestSpringBoot.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
