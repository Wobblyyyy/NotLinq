package me.wobblyyyy.notlinq;

import java.util.Collection;
import java.util.Map;

public class Linq {
    public static <T> ICollection<T> collection(Collection<T> collection) {
        return new ReferenceCollection<>(collection);
    }

    public static <T> IList<T> list(Collection<T> collection) {
        return new LinqList<>(collection);
    }

    public static <K, V> IMap<K, V> map(Map<K, V> map) {
        return new ReferenceMap<>(map);
    }
}
