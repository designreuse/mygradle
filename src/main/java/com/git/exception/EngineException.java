package com.git.exception;

import com.git.util.MessageHelper;

public class EngineException extends Exception {
    private int errorCode;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }


    public EngineException(int errorCode) {
        super(MessageHelper.getExceptionMessageByErrorCode(errorCode));
        this.errorCode = errorCode;
    }

    public EngineException(int errorCode, Throwable throwable) {
        super(MessageHelper.getExceptionMessageByErrorCode(errorCode), throwable);
        this.errorCode = errorCode;
    }

    public EngineException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public EngineException(Throwable throwable) {
        super(throwable);
    }

    public EngineException(String message) {
        super(message);
    }


    public String getErrorMessage(int errorCode){
        return MessageHelper.getExceptionMessageByErrorCode(errorCode);
    }

}
