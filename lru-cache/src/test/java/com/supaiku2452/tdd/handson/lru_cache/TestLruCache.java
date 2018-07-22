package com.supaiku2452.tdd.handson.lru_cache;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestLruCache {

    @Test
    public void testAddLruCache() {
        LruCache lruCache = new LruCache();
        assertTrue(lruCache.add("a", "data1"));
    }
}
