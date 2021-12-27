package me.wobblyyyy.notlinq.db;

import me.wobblyyyy.notlinq.IMap;
import me.wobblyyyy.notlinq.LinqMap;

import java.util.Map;

public class Row {
    private final IMap<Column, Object> values;

    public Row(Map<Column, Object> values) {
        this.values = new LinqMap<>(values);
    }

    public Row(int amountOfColumns) {
        values = new LinqMap<>(amountOfColumns);
    }

    public IMap<Column, Object> values() {
        return values;
    }

    public Object getObject(Column column) {
        return values.get(column);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Column column) {
        return (T) column.type().cast(values.get(column));
    }

    public String getString(Column column) {
        return (String) getObject(column);
    }

    public int getInt(Column column) {
        return (int) getObject(column);
    }

    public long getLong(Column column) {
        return (long) getObject(column);
    }

    public float getFloat(Column column) {
        return (float) getObject(column);
    }

    public double getDouble(Column column) {
        return (double) getObject(column);
    }

    public char getChar(Column column) {
        return (char) getObject(column);
    }

    public byte getByte(Column column) {
        return (byte) getObject(column);
    }
}
