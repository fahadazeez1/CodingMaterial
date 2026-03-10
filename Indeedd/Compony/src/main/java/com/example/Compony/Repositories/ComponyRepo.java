package com.example.Compony.Repositories;

import com.example.Compony.Entities.Compony;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ComponyRepo extends JpaRepository<Compony,Long> {
    Example<? extends Compony> Id(Long id);
}
