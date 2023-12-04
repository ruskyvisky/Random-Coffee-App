package com.coffee.Random.Coffee.App.Messages;

public enum Message {
    /** Messages */
    SUCCESS("SUCCESS", "İşlem Başarılı"),
    BAD_REQUEST("BAD_REQUEST", "Hatalı istek."),
    NOT_FOUND("NOT_FOUND", "Bulunamadı."),
    SYSTEM_ERROR("SYSTEM_ERROR", "Sistem hatası.");





    private final String text;
    private final String desc;

    Message(final String text, final String desc) {
        this.text = text;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return text;
    }

    public String getDesc() {
        return desc;
    }

    public String getDescWithExtraMessage(String extraMessage) {
        return desc + " " + extraMessage;
    }
}
