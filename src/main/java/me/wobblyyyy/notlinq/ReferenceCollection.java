package me.wobblyyyy.notlinq;

import java.util.Collection;
import java.util.Iterator;

public class ReferenceCollection<E> extends Ref<Collection<E>> implements ICollection<E> {
    private Collection<E> collection;

    public ReferenceCollection(Collection<E> collection) {
        super(collection);

        this.collection = collection;
    }

    @Override
    public Collection<E> get() {
        return collection;
    }

    @Override
    public void set(Collection<E> value) {
        collection = value;
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public boolean isEmpty() {
        return collection.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return collection.contains(o);
    }

    @Override
    public Object[] toArray() {
        return collection.toArray();
    }

    @SuppressWarnings("SuspiciousToArrayCall")
    @Override
    public <T> T[] toArray(T[] a) {
        return collection.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return collection.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return collection.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return collection.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return collection.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return collection.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return collection.retainAll(c);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return collection.iterator();
    }
}
