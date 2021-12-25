package me.wobblyyyy.notlinq;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public interface IMap<K, V> extends Map<K, V> {
    static <T, U> IMap<T, U> fromMap(Map<T, U> map) {
        return new ReferenceMap<>(map);
    }

    default boolean tryGetValue(K key,
                                Ref<V> output) {
        V value = get(key);
        boolean isNull = value == null;
        if (!isNull) output.set(value);
        return !isNull;
    }

    default <T> ICollection<T> select(Function<Map.Entry<K, V>, T> function) {
        ICollection<T> collection = new LinqList<>(size());
        for (Map.Entry<K, V> entry : entrySet()) {
            collection.add(function.apply(entry));
        }
        return collection;
    }

    default IMap<K, V> where(Predicate<Map.Entry<K, V>> predicate) {
        IMap<K, V> map = new LinqMap<>(size());
        for (Map.Entry<K, V> entry : entrySet()) {
            if (predicate.test(entry)) map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    default IMap<K, V> transform(Function<K, K> transformKey,
                                 Function<V, V> transformValue) {
        IMap<K, V> map = new LinqMap<>(size());
        for (Map.Entry<K, V> entry : entrySet()) {
            K newKey = transformKey.apply(entry.getKey());
            V newValue = transformValue.apply(entry.getValue());
            map.put(newKey, newValue);
        }
        return map;
    }

    default IMap<K, V> transformKeys(Function<K, K> transformKey) {
        IMap<K, V> map = new LinqMap<>(size());
        for (Map.Entry<K, V> entry : entrySet()) {
            K newKey = transformKey.apply(entry.getKey());
            V newValue = entry.getValue();
            map.put(newKey, newValue);
        }
        return map;
    }

    default IMap<K, V> transformValues(Function<V, V> transformValue) {
        IMap<K, V> map = new LinqMap<>(size());
        for (Map.Entry<K, V> entry : entrySet()) {
            K newKey = entry.getKey();
            V newValue = transformValue.apply(entry.getValue());
            map.put(newKey, newValue);
        }
        return map;
    }

    default IMap<K, V> removeAll(Iterable<K> keys) {
        for (K key : keys) {
            this.remove(key);
        }

        return this;
    }

    default IMap<K, V> removeAll(Predicate<Map.Entry<K, V>> predicate) {
        ICollection<Map.Entry<K, V>> toRemove = new LinqList<>(this.size());
        for (Map.Entry<K, V> entry : this.entrySet()) {
            if (predicate.test(entry)) toRemove.add(entry);
        }
        return removeAll(toRemove.select(Entry::getKey));
    }

    default IMap<K, V> removeIfKey(Predicate<K> predicate) {
        ICollection<K> toRemove = new LinqList<>(this.size());
        for (Map.Entry<K, V> entry : this.entrySet()) {
            K key = entry.getKey();
            if (predicate.test(key)) toRemove.add(key);
        }
        return removeAll(toRemove);
    }

    default IMap<K, V> removeIfValue(Predicate<V> predicate) {
        ICollection<K> toRemove = new LinqList<>(this.size());
        for (Map.Entry<K, V> entry : this.entrySet()) {
            if (predicate.test(entry.getValue())) toRemove.add(entry.getKey());
        }
        return removeAll(toRemove);
    }

    default ICollection<K> keyCollection() {
        return new ReferenceCollection<>(keySet());
    }

    default ICollection<V> valueCollection() {
        return new ReferenceCollection<>(values());
    }

    default ICollection<Map.Entry<K, V>> entryCollection() {
        return new ReferenceCollection<>(entrySet());
    }

    default ReferenceMap<K, V> reference() {
        return new ReferenceMap<>(this);
    }
}
