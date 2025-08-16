package com.example.util;

public class SinglyNode<T> {
    private T value;
    private SinglyNode<T> next;

    public SinglyNode(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setNext(SinglyNode<T> node) {
        this.next = node;
    }

    public SinglyNode<T> getNext() {
        return this.next;
    }
}
