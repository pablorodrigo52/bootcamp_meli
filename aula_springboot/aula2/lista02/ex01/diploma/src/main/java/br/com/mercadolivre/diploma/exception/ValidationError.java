package br.com.mercadolivre.diploma.exception;

public class ValidationError {

    private String field, message, rejectedValue;

    public ValidationError(String field, String message, String rejectedValue) {
        this.field = field;
        this.message = message;
        this.setRejectedValue(rejectedValue);
    }

    public String getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(String rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

}
