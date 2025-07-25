package org.payartz.restorapi.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    USER_NOT_FOUND(1001, "Kullanıcı bulunamadı."),
    RESTAURANT_NOT_FOUND(1002, "Restoran bulunamadı."),
    MENU_NOT_FOUND(1003, "Menü bulunamadı."),
    MENU_ITEM_NOT_FOUND(1004, "Menü öğesi bulunamadı."),
    ORDER_NOT_FOUND(1005, "Sipariş bulunamadı."),
    ORDER_ITEM_NOT_FOUND(1006, "Sipariş öğesi bulunamadı."),
    BRANCH_NOT_FOUND(1007, "Şube bulunamadı."),

    INVALID_INPUT(2001, "Geçersiz giriş yapıldı."),
    UNAUTHORIZED(2002, "Yetkisiz erişim."),
    VALIDATION_ERROR(2003, "Doğrulama hatası."),

    DUPLICATE_RESOURCE(2004, "Kayıt zaten mevcut."),
    GENERIC_ERROR(3000, "Genel hata oluştu.");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
