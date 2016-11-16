package com.raphaelsolarski.models;

public class SimpleClass {

    public Object methodThatReturnsObject() {
        return new Object();
    }

    public int methodThatReturnsInt() {
        return 1;
    }

    public int methodThatSometimesThrowsException(Integer integer) {
        if(integer == null) {
            throw new RuntimeException();
        }
        return 5;
    }

}
