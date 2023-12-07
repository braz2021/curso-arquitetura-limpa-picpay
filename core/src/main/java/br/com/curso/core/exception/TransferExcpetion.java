package br.com.curso.core.exception;

public class TransferExcpetion extends Exception {

    private String code;
    public TransferExcpetion(String message, String code) {
        super(message);
        this.code = code;
    }
}
