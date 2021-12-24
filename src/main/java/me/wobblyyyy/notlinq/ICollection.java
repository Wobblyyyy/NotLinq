package me.wobblyyyy.notlinq;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;

public interface ICollection<E> extends IIterable<E>, Collection<E> {
    static ICollection<Integer> range(int startInclusive,
                                      int stopExclusive) {
        ICollection<Integer> collection = new LinqList<>(stopExclusive - startInclusive);

        for (int i = startInclusive; i < stopExclusive; i++) {
            collection.add(i);
        }

        return collection;
    }

    default ICollection<E> where(Predicate<E> predicate) {
        LinqList<E> list = new LinqList<>(this.size());
        this.stream().filter(predicate).forEach(list::add);
        return list;
    }

    default ICollection<E> findAll(Predicate<E> predicate) {
        LinqList<E> list = new LinqList<>(this.size());
        this.stream().filter(predicate).forEach(list::add);
        return list;
    }

    default ICollection<E> concat(ICollection<E> that) {
        ICollection<E> collection = new LinqList<>(this.size() + that.size());
        collection.addAll(this);
        collection.addAll(that);
        return collection;
    }

    default ICollection<E> distinct() {
        ICollection<E> collection = new LinqList<>(this.size());
        this.forEach(element -> {
            if (!collection.contains(element)) collection.add(element);
        });
        return collection;
    }

    default <T> ICollection<T> select(Function<E, T> project) {
        ICollection<T> collection = new LinqList<>(this.size());
        this.forEach(element -> collection.add(project.apply(element)));
        return collection;
    }

    default E first() {
        for (E e : this) {
            return e;
        }
        return null;
    }

    default E first(Predicate<E> predicate) {
        for (E e : this) {
            if (predicate.test(e)) return e;
        }
        return null;
    }

    default E last() {
        E element = null;
        for (E e : this) element = e;
        return element;
    }

    default E last(Predicate<E> predicate) {
        E element = null;
        for (E e : this) if (predicate.test(e)) element = e;
        return element;
    }

    default double max() {
        double max = 0;
        for (E e : this) if (e instanceof Number) max = Math.max(max, (Double) e);
        return max;
    }

    default double min() {
        double min = 0;
        for (E e : this) if (e instanceof Number) min = Math.min(min, (Double) e);
        return min;
    }

    default int intMax() {
        return (int) max();
    }

    default int intMin() {
        return (int) min();
    }

    default float floatMax() {
        return (float) max();
    }

    default float floatMin() {
        return (float) min();
    }

    default char charMax() {
        return (char) max();
    }

    default char charMin() {
        return (char) min();
    }

    default byte byteMax() {
        return (byte) max();
    }

    default byte byteMin() {
        return (byte) min();
    }

    default double sum() {
        double sum = 0;
        for (E e : this) if (e instanceof Number) sum += (Double) e;
        return sum;
    }

    default int intSum() {
        return (int) sum();
    }

    default float floatSum() {
        return (float) sum();
    }

    default char charSum() {
        return (char) sum();
    }

    default byte byteSum() {
        return (byte) sum();
    }

    default double average() {
        return sum() / this.size();
    }

    default E single() {
        if (this.size() != 1) throw new RuntimeException();
        for (E e : this) return e;
        return null;
    }

    default ICollection<E> skip(int count) {
        ICollection<E> collection = new LinqList<>(this.size() - count);
        int i = 1;
        for (E e : this) {
            if (i > count) {
                collection.add(e);
            } else {
                i++;
            }
        }
        return collection;
    }

    default ICollection<E> skipLast(int count) {
        ICollection<E> collection = new LinqList<>(this.size() - count);
        int i = 0;
        for (E e : this) {
            if (i < this.size() - count) {
                collection.add(e);
            }
            i++;
        }
        return collection;
    }

    default ICollection<E> union(ICollection<E> that) {
        return this.concat(that).distinct();
    }

    default IList<E> toList() {
        return new LinqList<>(this);
    }

    default boolean any() {
        return this.size() > 0;
    }

    default boolean any(Predicate<E> predicate) {
        return first(predicate) != null;
    }

    default int count() {
        return this.size();
    }

    default E elementAt(int index) {
        int i = 0;
        E element = null;

        for (E e : this) {
            if (i == index) element = e;
            i++;
        }

        return element;
    }

    default int findIndex(E search) {
        int i = 0;

        for (E e : this) {
            if (e.equals(search)) return i;
            i++;
        }

        return -1;
    }

    default ICollection<Integer> findIndices(E search) {
        ICollection<Integer> collection = new LinqList<>(this.size());

        int i = 0;

        for (E e : this) {
            if (e.equals(search)) collection.add(i);
            i++;
        }

        return collection;
    }

    default ICollection<E> removeAll(Predicate<E> predicate) {
        ICollection<E> collection = new LinqList<>(this.size());

        for (E e : this) {
            if (!predicate.test(e)) collection.add(e);
        }

        return collection;
    }

    default ICollection<E> except(Predicate<E> predicate) {
        ICollection<E> collection = new LinqList<>(this.size());

        for (E e : this) {
            if (!predicate.test(e)) collection.add(e);
        }

        return collection;
    }

    default <T> IMap<E, T> toMap(Function<E, T> converter) {
        IMap<E, T> map = new LinqMap<>(this.size());

        for (E e : this) {
            map.put(e, converter.apply(e));
        }

        return map;
    }

    default <T> IMap<E, T> toMap(Collection<T> collection) {
        IList<E> list1 = new LinqList<>(this);
        IList<T> list2 = new LinqList<>(collection);

        if (list1.size() != list2.size()) {
            throw new IllegalArgumentException(
                    "Invalid toMap call - the provided collection was not " +
                            "the same length as this collection."
            );
        }

        IMap<E, T> map = new LinqMap<>(collection.size());

        for (int i = 0; i < list1.size(); i++) {
            map.put(list1.get(i), list2.get(i));
        }

        return map;
    }
}