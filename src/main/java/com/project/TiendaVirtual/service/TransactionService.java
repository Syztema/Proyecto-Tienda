package com.project.TiendaVirtual.service;

import com.project.TiendaVirtual.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();
    void saveTransaction(Transaction transaction);
    Transaction getTransactionById(long id);
    void deleteTransactionById(long id);
}
