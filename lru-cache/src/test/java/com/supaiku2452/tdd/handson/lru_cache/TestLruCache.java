package com.supaiku2452.tdd.handson.lru_cache;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestLruCache {

    @Test
    public void testAddLruCache() {
        String[][] testCacheDatas = {
                {"a", "data1"},
                {"b", "data2"},
                {"c", "data3"},
                {"d", "data4"},
        };

        LruCache lruCache = new LruCache();

        for ( String[] testCacheData : testCacheDatas ) {
            assertTrue(lruCache.add(testCacheData[0], testCacheData[1]));
        }

        assertNull(lruCache.get("a"));
    }

    @Test
    public void testUpdateLruCacheHistory() {
        String[] testCacheData = {"a", "data1"};

        LruCache lruCache = new LruCache();

        assertTrue(lruCache.add(testCacheData[0], testCacheData[1]));
        assertEquals(testCacheData[1], lruCache.get(testCacheData[0]).getValue());

        assertNotNull(lruCache.get("a"));
    }
}
