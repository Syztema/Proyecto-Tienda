package com.project.TiendaVirtual.controller;

import com.project.TiendaVirtual.model.Transaction;
import com.project.TiendaVirtual.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    /*@GetMapping("/")
    public String index(){
        return "index";
    }*/

    @GetMapping("/transaction")
    public String viewHomePage(Model model){
        model.addAttribute("listTransactions", transactionService.getAllTransactions());
        return "home_transaction";
    }

    @GetMapping("/showNewTransactionForm")
    public String showNewTransactionForm(Model model){
        //CREATE MODEL ATRIBUTE
        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);
        return "new_transaction";
    }

    @PostMapping("/saveTransaction")
    public String saveTransaction(@ModelAttribute("transaction")Transaction transaction){
        //SAVING ENTERPRISES IN DB
        transactionService.saveTransaction(transaction);
        return "redirect:/transaction";
    }

    @GetMapping("/showFormForUpdateTransaction/{id}")
    public String showFormForUpdateTransaction(@PathVariable(value = "id")long id, Model model){
        //GET TRANSACTIONS FROM THE SERVICE
        Transaction transaction = transactionService.getTransactionById(id);
        //SET TRANSACTIONS AS A MODEL ATRIBUTE TO PRE-POPULATE THE FORM
        model.addAttribute("transaction", transaction);
        return "update_transaction";
    }

    @GetMapping("/deleteTransaction/{id}")
    public String deleteTransaction(@PathVariable(value = "id")long id){
        //CALL DELETE TRANSACTION METHOD
        this.transactionService.deleteTransactionById(id);
        return "redirect:/transaction";
    }

}
