package com.bank.mobilewalletservice.model.document;

import com.bank.mobilewalletservice.model.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Document(value = "users")
public class User {
    @Id
    private String id;

    private DocumentType documentType;

    private String documentNumber;

    private String phoneNumber;

    private String imei;

    private String email;

    private Wallet wallet;

    public User(){
        this.wallet = new Wallet(0.0);
    }
}
