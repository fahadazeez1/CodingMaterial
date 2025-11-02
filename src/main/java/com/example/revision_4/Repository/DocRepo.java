package com.example.revision_4.Repository;

import com.example.revision_4.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocRepo extends JpaRepository<Doctor, Integer> {
}
