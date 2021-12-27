package me.wobblyyyy.notlinq.db;

import me.wobblyyyy.notlinq.ICollection;
import me.wobblyyyy.notlinq.LinqList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RowCollection extends LinqList<Row> {
    public RowCollection() {
        super();
    }

    public RowCollection(int initialSize) {
        super(initialSize);
    }

    public RowCollection(ICollection<Row> collection) {
        super(collection);
    }

    public ICollection<Row> rows() {
        return this;
    }

    public RowCollection insert(Row row) {
        add(row);

        return this;
    }

    public RowCollection insert(Pair... pairs) {
        Map<Column, Object> map = new HashMap<>(pairs.length);

        for (Pair pair : pairs) {
            map.put(pair.column(), pair.value());
        }

        Row row = new Row(map);

        return insert(row);
    }

    public RowCollection where(Column column,
                               Compare compare,
                               Object object) {
        return new RowCollection(this.where(row -> {
            Object value = row.get(column);

            if (value == null) return false;

            switch (compare) {
                case EQUALS:
                    return value.equals(object);
                case NOT_EQUALS:
                    return !value.equals(object);
                default:
                    return false;
            }
        }));
    }
}
