package com.example.revision_4.Entity;

import java.time.LocalDate;
import java.util.List;

import com.example.revision_4.ExtraStuff.GenderType;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(
        name = "petient",
        uniqueConstraints = {
        @UniqueConstraint(name = "unique-name" ,columnNames = {"petientname"})  },
        indexes = {
                @Index(name = "indx_petient_age" , columnList = "petientname")
        }
)
public class Petient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokennumber;
    private String petientname;
    private Integer petientage;
    @Enumerated(EnumType.STRING)
    private GenderType gender;

    // relations--->
    @OneToOne(cascade ={ CascadeType.ALL} ,orphanRemoval = true )
    private Insurance insurance;

    @OneToMany(mappedBy = "petient")
    private List<Appointment> appointments;






























    @Override
    public String toString() {
        return "Petient{" +
                "tokennumber=" + tokennumber +
                ", petientname='" + petientname + '\'' +
                ", petientage=" + petientage +
                ", gender='" + gender + '\'' +
                '}';
    }


}
