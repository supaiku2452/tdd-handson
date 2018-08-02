package com.supaiku2452.tdd.handson.sql_builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SqlBuilderTest {

    @Test
    public void testSelectQuery() {
        String actual = new SqlBuilder().select().table("user").build();
        assertEquals("select * from user;", actual);
    }

    @Test
    public void testSelectQueryWithColumn() {
        String actual = new SqlBuilder().select().table("user").column("name").build();
        assertEquals("select name from user;", actual);
    }

    @Test
    public void testSelectQueryWithCondition() {
        String actual = new SqlBuilder().select().table("user").column("name").where("age = 20").build();
        assertEquals("select name from user where age = 20;", actual);
    }

    @Test
    public void testSelectQueryWithMultiCondition() {
        String actual = new SqlBuilder().select().table("user").column("name").where("age = 20").where("name = 'kanai'").build();
        assertEquals("select name from user where age = 20 and name = 'kanai';", actual);
    }
}
