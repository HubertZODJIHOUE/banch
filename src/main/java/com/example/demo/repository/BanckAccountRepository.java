package com.example.demo.repository;

import com.example.demo.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanckAccountRepository extends JpaRepository<BankAccount, Long> {
}
