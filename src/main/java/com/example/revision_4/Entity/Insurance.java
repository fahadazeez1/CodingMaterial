package com.example.revision_4.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ins_id;

    @Column(nullable = false,length = 30)
    private String policynumber;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDate cration_date;

    @Column(nullable = false)
    private LocalDate expiry_date;

    @OneToOne(mappedBy = "insurance")
    private Petient petient;
}
