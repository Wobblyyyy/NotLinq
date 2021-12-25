package me.wobblyyyy.notlinq;

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
