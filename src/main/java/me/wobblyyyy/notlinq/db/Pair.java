package me.wobblyyyy.notlinq.db;

public class Pair {
    private Column column;
    private Object value;

    public Pair(Column column,
                Object value) {
        this.column = column;
        this.value = value;
    }

    public Column column() {
        return column;
    }

    public Object value() {
        return value;
    }
}
