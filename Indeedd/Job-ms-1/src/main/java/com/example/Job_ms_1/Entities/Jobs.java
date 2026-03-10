package com.example.Job_ms_1.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String role;
    private String description;
    private LocalDate applicationEndDate;
    private LocalDate applicationStartDate;
    private Long openings;
//    @ManyToOne
//    @JoinColumn(name = "compony_id")
    private Long componyId;
}
