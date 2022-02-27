package me.wobblyyyy.notlinq.tuples;

public class Tuple1<A> {
    private final A a;

    public Tuple1(A a) {
        this.a = a;
        this.b = b;
    }

    public Tuple1(Tuple1<A> tuple) {
        this(tuple.a);
    }

    public A a() {
        return a;
    }
}
