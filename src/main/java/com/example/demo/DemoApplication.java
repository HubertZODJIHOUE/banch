package com.example.demo;

import com.example.demo.controller.BanckAccountController;
import com.example.demo.controller.ClientController;
import com.example.demo.entities.BankAccount;
import com.example.demo.entities.Client;
import com.example.demo.repository.BanckAccountRepository;
import com.example.demo.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BanckAccountController banckAccountController , ClientController clientController , ClientRepository clientRepository, BanckAccountRepository banckAccountRepository){
		return args -> {
			Client client = new Client(null,"AROUND","Tanneur",new ArrayList<>());
			Client client1 = new Client(null,"MARC","diraj",new ArrayList<>());
			Client client2 = new Client(null,"ARTHUR","turfu",new ArrayList<>());
			Client client3 = new Client(null,"CRISTIAN","teste",new ArrayList<>());
			Client client4 = new Client(null,"MACRON","emmanuel",new ArrayList<>());

			clientRepository.save(client1);
			clientRepository.save(client);
			clientRepository.save(client2);
			clientRepository.save(client3);
			clientRepository.save(client4);

			BankAccount bankAccount= new BankAccount(null,"12345",client2,0,0);
			BankAccount bankAccount1= new BankAccount(null,"465353",client1,0,0);
			BankAccount bankAccount2= new BankAccount(null,"98E66E",client1,0,0);
			BankAccount bankAccount3= new BankAccount(null,"553663",client3,0,0);
			BankAccount bankAccount4= new BankAccount(null,"77E6E7",client2,0,0);

			banckAccountRepository.save(bankAccount);
			banckAccountRepository.save(bankAccount1);
			banckAccountRepository.save(bankAccount2);
			banckAccountRepository.save(bankAccount3);
			banckAccountRepository.save(bankAccount4);
		};
	}
}
