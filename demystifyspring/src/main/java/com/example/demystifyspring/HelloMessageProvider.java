package com.example.demystifyspring;

public class HelloMessageProvider {

    private final HelloNameProvider helloNameProvider;

    HelloMessageProvider(HelloNameProvider helloNameProvider) {
        this.helloNameProvider = helloNameProvider;
    }

    public String getMessage() {
        return "Hello! " + this.helloNameProvider.getName();
    }
}
