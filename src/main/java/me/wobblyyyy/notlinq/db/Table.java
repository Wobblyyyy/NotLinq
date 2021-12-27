package me.wobblyyyy.notlinq.db;

import me.wobblyyyy.notlinq.ICollection;
import me.wobblyyyy.notlinq.LinqList;

public class Table {
    private final String name;
    private final ICollection<Row> rowCollection = new LinqList<>(500);
    private final RowCollection rows = new RowCollection(rowCollection);

    public Table(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public RowCollection rows() {
        return rows;
    }
}
