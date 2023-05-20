package com.challenge.paygoal.exception;

public class ParamNotFound extends RuntimeException{
    public ParamNotFound(String error) {
        super(error);
    }
}
