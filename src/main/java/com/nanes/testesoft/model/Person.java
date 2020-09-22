package com.nanes.testesoft.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Version;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name; //obrigatorio
    private String sex;
    private String email; //não obrigatorio, avaliado caso preenchido
    private Date birthDate; //obrigaotorio
    private String naturality;
    private String nationality;
    @Column(unique = true)
    private String cpf;

    @Version
    @Column(name="UPDATE_TS")
    private Calendar dateMaj;


}
