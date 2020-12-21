package com.mikehenry.springbootjpabeginner.repository;

import com.mikehenry.springbootjpabeginner.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long> {
}
