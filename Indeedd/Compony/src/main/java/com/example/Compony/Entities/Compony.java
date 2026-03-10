package com.example.Compony.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Compony {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private int employees;


//
//    @JsonIgnore
//    @OneToMany(mappedBy = "compony", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Jobs> jobs;

//    @JsonIgnore
//    @OneToMany(mappedBy = "compony" ,cascade = CascadeType.ALL ,orphanRemoval = true)
//    private List<Review> review;
}
