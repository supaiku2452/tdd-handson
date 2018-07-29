package com.supaiku2452.tdd.handson.lru_cache;

import org.junit.Ignore;
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

    @Test
    public void testDeleteFirstAddedCacheWhenAllNull() {
        String[][] testCacheDatas = {
                {"a", "data1"},
                {"b", "data2"},
                {"c", "data3"},
                {"d", "data4"},
        };

        LruCache lruCache = new LruCache();

        for ( String[] testCacheData : testCacheDatas ) {
            lruCache.add(testCacheData[0], testCacheData[1]);
        }

        assertNull(lruCache.get("a"));

        String[] newAddData = {"e", "data5"};
        lruCache.add(newAddData[0], newAddData[1]);

        assertNull("check key {b}:", lruCache.get("b"));
    }

    @Test
    public void testDeleteUnusedData() {
        String[][] testCacheDatas = {
                {"a", "data1"},
                {"b", "data2"},
                {"c", "data3"},
        };

        LruCache lruCache = new LruCache();

        for ( String[] testCacheData : testCacheDatas ) {
            lruCache.add(testCacheData[0], testCacheData[1]);
        }

        // Use 'a' and 'c'
        lruCache.get("a");
        lruCache.get("c");

        String[] newAddData = {"d", "data4"};
        lruCache.add(newAddData[0], newAddData[1]);

        assertNull("check key {b}:", lruCache.get("b"));
    }

    @Test
    public void testDeleteMostOldDataWhenAllUsed() {
        String[][] testCacheDatas = {
                {"a", "data1"},
                {"b", "data2"},
                {"c", "data3"},
        };

        LruCache lruCache = new LruCache();

        for ( String[] testCacheData : testCacheDatas ) {
            lruCache.add(testCacheData[0], testCacheData[1]);
        }

        // Use 'a' and 'b' and 'c'
        lruCache.get("a");
        lruCache.get("b");
        lruCache.get("c");

        String[] newAddData = {"d", "data4"};
        lruCache.add(newAddData[0], newAddData[1]);

        assertNull("check key {a}:", lruCache.get("a"));
    }

    @Test
    public void testDeleteOldestDataWhenCacheFull() throws InterruptedException{
        String[][] testCacheDatas = {
                {"a", "data1"},
                {"b", "data2"},
                {"c", "data3"},
        };

        LruCache lruCache = new LruCache();

        for ( String[] testCacheData : testCacheDatas ) {
            lruCache.add(testCacheData[0], testCacheData[1]);
        }

        // Use 'a' and 'b' and 'c'
        lruCache.get("c");
        Thread.sleep(1000);
        lruCache.get("b");
        Thread.sleep(1000);
        lruCache.get("a");

        lruCache.add("d", "data4");

        assertNull(lruCache.get("c"));
    }
}
