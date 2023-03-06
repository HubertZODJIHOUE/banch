package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Array;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @JsonIgnoreProperties({"propriete1", "propriete2"}) @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private final int MAX_BANK_ACCOUNT = 5;
    private  String nom;
    private  String prenoms;


    @OneToMany(mappedBy = "client")
    private List<BankAccount>  bankAccountListe ;
}
