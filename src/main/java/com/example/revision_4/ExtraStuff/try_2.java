package com.example.revision_4.ExtraStuff;

import com.example.revision_4.Entity.Petient;
import com.example.revision_4.Repository.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class try_2 {
    @Autowired
    private PetRepo petRepo;

    @Autowired
    private try_1 try1;
    @GetMapping("/")
    public  void chk(){
    try1.check();

    }

    @GetMapping("/gbs/{chars}")
    public List<Petient> findbychar(@PathVariable String chars){
        System.out.println(petRepo.findByStartingchar(chars));
        return petRepo.findByStartingchar(chars);
    }

    @GetMapping("/count")
    public StringBuilder chckcount(){
        List<Object[]> pcount = petRepo.checkbycount();
        StringBuilder sums= new StringBuilder("");
        for (Object[] obj:pcount){
            sums.append(obj[0]);
            sums.append("=");
            sums.append(obj[1]);
            System.out.println(obj[0]+" = "+obj[1]);
        }
        return  sums;
    }


    @PatchMapping("/update/{id}")
    public int afterupdate(@PathVariable Integer id  , @RequestBody String name){
       return try1.updatename(id,name);

    }

}
