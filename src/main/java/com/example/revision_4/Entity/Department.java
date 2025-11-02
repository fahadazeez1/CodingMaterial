package com.example.revision_4.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.print.Doc;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer department_id;
    @Column(nullable = false, unique = true,length = 30)
    private String department_name;



    // relationship
    @OneToOne
    private Doctor doctorhead;

    @ManyToMany
    @JoinTable(
            name = "dpt_docor",
            joinColumns = @JoinColumn(name = "dep_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_id")
    )
    private Set<Doctor> doctorxset = new HashSet<>();
}
