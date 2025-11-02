package com.example.revision_4.ExtraStuff;

import com.example.revision_4.Repository.PetRepo;
import org.springframework.stereotype.Service;

@Service
public class try_1 {

private  final PetRepo petRepo;


    public try_1(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

   public void check(){
       System.out.println(petRepo.findAll());

    }

    public int updatename(Integer id, String name) {
        int result= petRepo.nameupdate(id,name);
        System.out.println("total update resuly ="+result);
        return result;
    }



}
