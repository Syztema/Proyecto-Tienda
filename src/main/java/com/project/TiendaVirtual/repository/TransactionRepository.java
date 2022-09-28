package com.project.TiendaVirtual.repository;

import com.project.TiendaVirtual.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    //GENERA EL CRUD
}
