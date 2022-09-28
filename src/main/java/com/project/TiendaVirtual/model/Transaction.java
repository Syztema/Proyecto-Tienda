package com.project.TiendaVirtual.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "concept")
    private String concept;
    @Column(name = "amount")
    private float amount;
    @Column(name = "createdAt")
    private LocalDate createdAt;

    //CONSTRUCTORS
    public Transaction(long id, String concept, float amount, LocalDate createdAt) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.createdAt = createdAt;
    }
    public Transaction() {
    }

    //GETTERS AND SETTERS
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getConcept() {
        return concept;
    }
    public void setConcept(String concept) {
        this.concept = concept;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

}
