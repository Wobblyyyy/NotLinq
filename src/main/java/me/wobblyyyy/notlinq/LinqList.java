package me.wobblyyyy.notlinq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class LinqList<E> extends ArrayList<E> implements IList<E> {
    public LinqList(int initialCapacity) {
        super(initialCapacity);
    }

    public LinqList() {
        super();
    }

    public LinqList(Collection<? extends E> c) {
        super(c);
    }

    public LinqList(E[] elements) {
        super(Arrays.asList(elements));
    }

    @Override
    public ICollection<E> take(int count) {
        ICollection<E> collection = new LinqList<>(count);
        for (int i = count - 1; i < size(); i++) {
            collection.add(get(i));
        }
        return collection;
    }
}
