package com.example.revision_4.Service;

import com.example.revision_4.Entity.Insurance;
import com.example.revision_4.Entity.Petient;
import com.example.revision_4.Repository.InsRepo;
import com.example.revision_4.Repository.PetRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class InsService_1 {
    private  final  PetRepo petRepo;
    private   final InsRepo insRepo;

    @Transactional
    public void assign_ins_to_pet(Insurance insurance , Integer Id){
        Petient petient =petRepo.findByTokennumber(Id);//.orElseThrow(()-> new EntityNotFoundException("sorry no pet "));
        petient.setInsurance(insurance);
        insurance.setPetient(petient);
        System.out.println(petient);
    }

}
