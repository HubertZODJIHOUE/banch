package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Array;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private final int MAX_BANK_ACCOUNT = 5;
    private  String nom;
    private  String prenoms;
    private  double libelle;

    @OneToMany(mappedBy = "client")
    private List<BankAccount>  bankAccountListe ;
}
