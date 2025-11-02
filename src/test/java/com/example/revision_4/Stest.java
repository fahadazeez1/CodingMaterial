package com.example.revision_4;

import java.time.LocalDate;

import com.example.revision_4.Entity.Appointment;
import com.example.revision_4.Service.AppService;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.revision_4.Entity.Insurance;
import com.example.revision_4.Service.InsService_1;

@SpringBootTest
public class Stest{
    @Autowired
    private InsService_1 insService_1;

    @Autowired
    private AppService appService;

    @Test
    public void stets_1(){
        Insurance insurance = Insurance.builder()
                .policynumber("HDFC_1120")
                .expiry_date(LocalDate.of(1999,12,12))
                .build();
        System.out.println("ths is opppp-------------");
        insService_1.assign_ins_to_pet(insurance,9);
    }



    @Test
    public void trya(){
        Appointment appointment = Appointment.builder()
                .appointment_time(LocalDate.of(2025,12,12))
                .appointment_reason("checkup basic")
                .build();

        appService.createnewApp(appointment,2,2);
    }


    @Test
    public  void detach(){
        appService.detachinsfrompet(9);
    }

}
