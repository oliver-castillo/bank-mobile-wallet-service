package com.bank.mobilewalletservice.model.dto.request;

import com.bank.mobilewalletservice.model.enums.DocumentType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserRequest {
    @NotNull
    private Integer documentId;

    private DocumentType documentType;

    @NotNull
    private String documentNumber;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String imei;

    @NotNull
    private String email;

    public UserRequest(Integer documentId) {
        this.documentId = documentId;
        this.documentType = DocumentType.fromId(documentId);
    }
}
