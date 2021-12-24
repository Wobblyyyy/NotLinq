package me.wobblyyyy.notlinq;

import java.util.HashMap;
import java.util.Map;

public class LinqMap<K, V> extends HashMap<K, V> implements IMap<K, V> {
    public LinqMap(int initialCapacity,
                   float loadFactor) {
        super(
                initialCapacity,
                loadFactor
        );
    }

    public LinqMap(int initialCapacity) {
        super(initialCapacity);
    }

    public LinqMap() {
        super();
    }

    public LinqMap(Map<? extends K, ? extends V> m) {
        super(m);
    }
}
