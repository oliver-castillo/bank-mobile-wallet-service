package com.bank.mobilewalletservice.model.enums;

import lombok.Getter;

@Getter
public enum DocumentType {
    DNI(1),
    FOREIGN_ID_CARD(2),
    PASSPORT(3);

    private final int id;

    DocumentType(int id) {
        this.id = id;
    }

    public static DocumentType fromId(int value) {
        for (DocumentType type : DocumentType.values()) {
            if (type.id == value) {
                return type;
            }
        }
        return null;
    }
}
