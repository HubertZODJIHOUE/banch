package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @AllArgsConstructor @Data @NoArgsConstructor @JsonIgnoreProperties({"propriete1", "propriete2"}) @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idBankAccount;

    private String libele;
    @ManyToOne
    private  Client client;
    @Transient
    private double montantAcrediteOuAdebite;

    private double soldeTotal =0;

    public   String creditAccount( double soldeAcrediter){
        this.soldeTotal+=soldeAcrediter;
        return  "votre compte libellé "+ this.libele + "a été credité de " + soldeAcrediter + ". Votre nouveau solde est de "+ this.soldeTotal;
    }

    public  String debitAccount( double soldeAdebiter){
        this.soldeTotal-=soldeAdebiter;
        return  "votre compte libellé "+ this.libele + "a été debité de " + soldeAdebiter + ". Votre nouveau solde est de "+ this.soldeTotal;
    }
}
