package com.nanes.testesoft.exception;

public class PersonAlreadyExistsException extends RuntimeException {
    public PersonAlreadyExistsException(String name) { super("Nickname: " + name + " already exists."); }
}