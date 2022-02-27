package me.wobblyyyy.notlinq.tuples;

public class Tuple2<A, B> {
    private final A a;
    private final B b;

    public Tuple2(A a,
                  B b) {
        this.a = a;
        this.b = b;
    }

    public Tuple2(Tuple2<A, B> tuple) {
        this(tuple.a, tuple.b);
    }

    public A a() {
        return a;
    }

    public B b() {
        return b;
    }
}
