package me.wobblyyyy.notlinq;

public class Reference<E> extends Ref<E> {
    public Reference() {
        super();
    }

    public Reference(E initialValue) {
        super(initialValue);
    }

    @Override
    public E get() {
        return super.get();
    }

    @Override
    public void set(E value) {
        super.set(value);
    }
}
