package com.example.revision_4.Repository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.revision_4.Entity.Petient;

import java.util.List;
import com.example.revision_4.ExtraStuff.GenderType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PetRepo extends JpaRepository<Petient,Integer>{
    public  List<Petient> findByGender(GenderType gender);


    public  Petient findBypetientname(String petientname);

        public Petient findByTokennumber(Integer i);

        @Query("SELECT s from Petient s where s.petientname like ?1%")
        public List<Petient> findByStartingchar(@Param("petientname") String petientname);

        @Query("SELECT s.gender , count(s.gender) from Petient s Group by s.gender ")
        public List<Object[]> checkbycount();

        @Transactional
        @Modifying
        @Query(value = "UPDATE petient SET petientname =:name where tokennumber =:id",nativeQuery = true)
        int nameupdate(Integer id , String name);
             // SELECT s.gender , count(s.gender) from Petient s Group by s.gender



}

