package me.wobblyyyy.notlinq;

import java.util.concurrent.atomic.AtomicReference;

public class Ref<E> {
    private E value = null;

    public Ref() {

    }

    public Ref(E initialValue) {
        value = initialValue;
    }

    public E get() {
        return value;
    }

    public void set(E value) {
        this.value = value;
    }

    public boolean exists() {
        return value != null;
    }

    public AtomicReference<E> atomicReference() {
        return new AtomicReference<>(value);
    }

    public Reference<E> reference() {
        return new Reference<>(value);
    }

    @Override
    public int hashCode() {
        return value.hashCode() + 1_234_567;
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
