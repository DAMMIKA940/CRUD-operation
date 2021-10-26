package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String loanName;
    @NonNull
    private String loanDesc;
    @NonNull
    private int monthlyFee;
    @NonNull
    private Timestamp createdAt;

    @OneToMany(targetEntity = Subscription.class, mappedBy = "loan",  cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Subscription> subscriptions;

    public Loan() {
    }

    public Loan(Integer id, @NonNull String loanName, @NonNull String loanDesc, int monthlyFee, @NonNull Timestamp createdAt, Set<Subscription> subscriptions) {
        this.id = id;
        this.loanName = loanName;
        this.loanDesc = loanDesc;
        this.monthlyFee = monthlyFee;
        this.createdAt = createdAt;
        this.subscriptions = subscriptions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NonNull
    public String getLoanName() {
        return loanName;
    }
    @NonNull
    public void setLoanName(@NonNull String loanName) {
        this.loanName = loanName;
    }




    @NonNull
    public String getLoanDesc() {
        return loanDesc;
    }

    public void setLoanDesc(@NonNull String loanDesc) {
        this.loanDesc = loanDesc;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(int monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    @NonNull
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
