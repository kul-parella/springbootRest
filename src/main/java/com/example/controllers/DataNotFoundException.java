package com.example.controllers;

public class DataNotFoundException extends RuntimeException {

public DataNotFoundException() {

}

public DataNotFoundException(String s, Throwable throwable) {
    super(s, throwable);
}

public DataNotFoundException(String s) {
    super(s);
}

}
