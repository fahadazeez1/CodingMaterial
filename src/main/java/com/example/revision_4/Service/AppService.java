package com.example.revision_4.Service;

import com.example.revision_4.Entity.Appointment;
import com.example.revision_4.Entity.Doctor;
import com.example.revision_4.Entity.Petient;
import com.example.revision_4.Repository.AppRepo;
import com.example.revision_4.Repository.DocRepo;
import com.example.revision_4.Repository.PetRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AppService {
private  final DocRepo docRepo;
private final PetRepo petRepo;
private final AppRepo appRepo;



@Transactional
public void createnewApp(Appointment appointment , Integer docid , Integer petid){
    Doctor doctor = docRepo.findById(docid).orElseThrow(()-> new EntityNotFoundException("no doctor with id - "+docid));
    Petient petient=petRepo.findById(petid).orElseThrow(()->new EntityNotFoundException("no peteint with id - "+petid));

    appointment.setPetient(petient);
    appointment.setDoctor_app(doctor);

    appRepo.save(appointment);
    System.out.println(appointment);

}


@Transactional
public void detachinsfrompet(Integer petid){
    Petient petient=petRepo.findById(petid).orElseThrow(()->new EntityNotFoundException("no peteint with id - "+petid));
    petient.setInsurance(null);
    System.out.println(petient);
}



}
