package com.example.revision_4.Repository;

import com.example.revision_4.Entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsRepo extends JpaRepository<Insurance, Integer> {
}