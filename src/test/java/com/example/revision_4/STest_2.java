//package com.example.revision_4;
//
//import java.time.LocalDate;
//
//import org.junit.jupiter.api.AutoClose;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.revision_4.Entity.Insurance;
//import com.example.revision_4.Service.InsService_1;
//
//@SpringBootTest
//public class STest_2 {
//    @Autowired
//    private InsService_1 insService_1;
//
//    @Test
//    public void stets_1(){
//        Insurance insurance = Insurance.builder()
//                                    .policynumber("IDBI_2120")
//                                    .expiry_date(LocalDate.of(1999,12,12))
//                                    .build();
//        System.out.println("ths is opppp-------------");
//        insService_1.assign_ins_to_pet(insurance,1);
//    }
//}
