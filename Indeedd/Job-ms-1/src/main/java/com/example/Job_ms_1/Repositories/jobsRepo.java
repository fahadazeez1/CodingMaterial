package com.example.Job_ms_1.Repositories;

import com.example.Job_ms_1.Entities.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface jobsRepo extends JpaRepository<Jobs,Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Jobs j WHERE j.id = :id")
    int deleteJobByIdDirectly(@Param("id") Long id);

    List<Jobs> findByComponyId(Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Jobs j WHERE j.componyId = :id")
    int deleteJobByCompanyId(Long id);
}
