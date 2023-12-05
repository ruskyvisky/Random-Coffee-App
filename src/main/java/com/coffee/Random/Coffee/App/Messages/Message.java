package com.coffee.Random.Coffee.App.Messages;

public enum Message {
    /** Messages */
    SUCCESS("SUCCESS", "Success"),
    BAD_REQUEST("BAD_REQUEST", "Bad Request."),
    NOT_FOUND("NOT_FOUND", "Not Found."),
    SYSTEM_ERROR("SYSTEM_ERROR", "System Error."),

    DATA_TOO_LONG("DATA_TOO_LONG", "Data Too Long."),

    DATA_TOO_SHORT("DATA_TOO_SHORT", "Data Too Short."),

    ALREADY_EXISTS("ALREADY_EXISTS", "This Coffee Already Exists."),
    MISSING_DATA("MISSING_DATA", "Missing Data."),

    DATA_CONTAINS_NUMBER("DATA_CONTAINS_NUMBER", "Data Contains Number.");






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
