package com.example.revision_4.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctor_id;
    @Column(length = 30)
    private String doctor_type;
    @Column(nullable = false)
    private String doctor_email;

    //raltionships-->

    @OneToMany(mappedBy ="doctor_app" )
    private List<Appointment> appointment;

    @ManyToMany(mappedBy = "doctorxset")
    private Set<Department> departmentset =new HashSet<>();


}
