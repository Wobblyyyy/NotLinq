package me.wobblyyyy.notlinq.db;

import me.wobblyyyy.notlinq.IMap;
import me.wobblyyyy.notlinq.LinqMap;

import java.util.Map;

public class Database {
    private final IMap<String, Table> tables = new LinqMap<>(10);

    public Database() {

    }

    public IMap<String, Table> getTables() {
        return tables;
    }

    public Table get(String tableName) {
        return tables.get(tableName);
    }

    public Database addTable(Table table) {
        tables.put(table.name(), table);

        return this;
    }

    public static void main(String[] args) {
        Database database = new Database();
        Column name = new Column("name", String.class);
        Column color = new Column("color", String.class);
        Column car = new Column("car", String.class);
        Column age = new Column("age", Integer.class);
        Column country = new Column("country", String.class);
        Table people = new Table("people");
        database.addTable(people);
        database.get("people")
                .rows()
                .insert(
                        new Pair(name, "colin"),
                        new Pair(color, "purple"),
                        new Pair(car, "honda civic"),
                        new Pair(age, 18),
                        new Pair(country, "usa"))
                .insert(
                        new Pair(name, "alec"),
                        new Pair(color, "beige"),
                        new Pair(car, "who knows"),
                        new Pair(age, 15),
                        new Pair(country, "usa"))
                .where(name, Compare.EQUALS, "colin")
                .where(country, Compare.EQUALS, "usa").forEach(row -> {
                    for (Map.Entry<Column, Object> entry : row.values().entrySet()) {
                        System.out.printf(
                                "%s: %s%n",
                                entry.getKey().name(),
                                entry.getValue()
                        );
                    }
                    System.out.println();
                });
    }
}
