package com.example.revision_4.Entity;

import jakarta.persistence.*;
import lombok.*;

import javax.print.Doc;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointment_id;

    @Column(nullable = false)
    private LocalDate appointment_time;

    @Column(length = 50)
    private String appointment_reason;


    // relations=--->


    @ManyToOne
    @JoinColumn(name = "tokennumber" , nullable = false)
    private Petient petient;

    @ManyToOne()
    @JoinColumn(name = "doctor", nullable = false)
    private Doctor doctor_app;

}
