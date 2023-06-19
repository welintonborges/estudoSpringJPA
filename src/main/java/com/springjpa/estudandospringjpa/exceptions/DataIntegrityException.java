package com.springjpa.estudandospringjpa.exceptions;

public class DataIntegrityException extends RuntimeException{
    public DataIntegrityException(String msg) {
        super(msg);
    }

    public DataIntegrityException(String msg, Throwable causa){
        super(msg, causa);
    }
}
