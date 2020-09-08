package com.recruitment.demo.emeraldAccount;


import javax.persistence.*;

@Entity
@Table(name = "emerald_account")
public class EmeraldAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private double emeraldAccount;

    public EmeraldAccount() {
    }

    public double getEmeraldAccount() {
        return emeraldAccount;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmeraldAccount(double emeraldAccount) {
        this.emeraldAccount = emeraldAccount;
    }

    public EmeraldAccount(double emeraldAccount) {
        this.emeraldAccount = emeraldAccount;


    }
}
