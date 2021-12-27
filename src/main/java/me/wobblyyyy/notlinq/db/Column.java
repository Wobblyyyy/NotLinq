package me.wobblyyyy.notlinq.db;

public class Column {
    private final String name;
    private final Class<?> type;

    public Column(String name,
                  Class<?> type) {
        this.name = name;
        this.type = type;
    }

    public String name() {
        return name;
    }

    public Class<?> type() {
        return type;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Column) {
            Column c = (Column) obj;
            return c.name.equalsIgnoreCase(this.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
