package com.example.util;

public class DoublyNode<T> {
    private T value;
    private DoublyNode<T> previous;
    private DoublyNode<T> next;

    public DoublyNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setPrevious(DoublyNode<T> previous) {
        this.previous = previous;
    }

    public DoublyNode<T> getPrevious() {
        return previous;
    }

    public void setNext(DoublyNode<T> next) {
        this.next = next;
    }

    public DoublyNode<T> getNext() {
        return next;
    }
}
