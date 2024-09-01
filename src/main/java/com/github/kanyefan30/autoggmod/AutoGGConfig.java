package com.github.kanyefan30.autoggmod;

public class AutoGGConfig {
    public static String message = "gg";

    public static void setMessage(String newMessage) {
        message = newMessage;
    }

    public static String getMessage() {
        return message;
    }

    public static void resetMessage() {
        message = "gg";
    }
}
