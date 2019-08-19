package com.project.donation;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Data  //getters and setters
@AllArgsConstructor
@Entity
public class Personae {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nume;
    private String prenume;
    private String email;
    private String bloodgroup;
    public Personae() {}
}
