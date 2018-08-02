package com.supaiku2452.tdd.handson.sql_builder;

import java.util.ArrayList;
import java.util.List;

public class SqlBuilder {

    private String operator;
    private List<String> tableList = new ArrayList<>();
    private List<String> columnList = new ArrayList<>();
    private List<String> conditionList = new ArrayList<>();

    public SqlBuilder() {}

    public String build() {
        StringBuilder query = new StringBuilder();
        // select
        query.append(operator);
        query.append(" ");

        // column
        query.append(
            columnList.size() == 0 ?
                    "*" :
                    String.join(", ", columnList)
        );

        query.append(" from ");

        // table
        query.append(String.join(", ", tableList));

        // condition
        if ( conditionList.size() != 0 ) {
            query.append(" where " + String.join(" and ", conditionList));
        }

        query.append(";");

        return query.toString();
    }

    public SqlBuilder select() {
        operator = "select";
        return this;
    }

    public SqlBuilder table(String tableName) {
        tableList.add(tableName);
        return this;
    }

    public SqlBuilder column(String columnName) {
        columnList.add(columnName);
        return this;
    }

    public SqlBuilder where(String condition) {
        conditionList.add(condition);
        return this;
    }
}
