package me.wobblyyyy.notlinq.tuples;

public class Tuple3<A, B, C> {
    private final A a;
    private final B b;
    private final C c;

    public Tuple3(A a,
                  B b,
                  C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Tuple3(Tuple3<A, B, C> tuple) {
        this(tuple.a, tuple.b, tuple.c);
    }

    public A a() {
        return a;
    }

    public B b() {
        return b;
    }

    public C c() {
        return c;
    }
}
