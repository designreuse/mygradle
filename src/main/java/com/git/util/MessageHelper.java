package com.git.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageHelper {
    public static String getExceptionMessageByErrorCode(int errorCode) {

        ResourceBundle rb = ResourceBundle.getBundle("errorMessages", Locale.getDefault());
        String message = rb.getString(String.valueOf(errorCode));

        return message;

    }
}
