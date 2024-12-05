package com.bank.mobilewalletservice.model.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Document(value = "wallets")
public class Wallet {
    @Id
    private String id = UUID.randomUUID().toString();

    private Double balance;

    public Wallet(Double balance) {
        this.balance = balance;
    }
}
