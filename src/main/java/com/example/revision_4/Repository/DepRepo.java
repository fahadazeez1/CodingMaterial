package com.example.revision_4.Repository;

import com.example.revision_4.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepRepo extends JpaRepository<Department, Integer> {
}