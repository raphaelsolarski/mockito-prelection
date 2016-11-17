package com.raphaelsolarski.models;

import java.util.Collection;

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

    public void voidMethodThatThrowsException() {
        throw new RuntimeException();
    }

    public int methodThatGetsString(String arg) {
        return 20;
    }

    public int methodThatGetsCollection(Collection<?> collection) {
        return collection.size();
    }

    public void methodThatGetsObject(Object object) {
    }

    public String methodWithTwoParameters(String arg1, String arg2) {
        return "hello";
    }

}
