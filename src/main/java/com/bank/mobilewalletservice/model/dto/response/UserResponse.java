package com.bank.mobilewalletservice.model.dto.response;

import com.bank.mobilewalletservice.model.document.Wallet;
import com.bank.mobilewalletservice.model.enums.DocumentType;
import lombok.Data;

@Data
public class UserResponse {
    private String id;

    private DocumentType documentType;

    private String documentNumber;

    private String phoneNumber;

    private String imei;

    private String email;

    private Wallet wallet;
}
