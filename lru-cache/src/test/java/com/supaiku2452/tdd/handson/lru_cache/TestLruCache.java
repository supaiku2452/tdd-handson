package com.supaiku2452.tdd.handson.lru_cache;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

        Arrays.asList(testCacheDatas).stream().forEach(testCacheData -> {
            assertTrue(lruCache.add(testCacheData[0], testCacheData[1]));
            assertEquals(testCacheData[1], lruCache.get(testCacheData[0]));
        });

        // 最初に追加したデータはNullであるはず
        assertEquals(null, lruCache.get("a"));
    }

    @Test
    public void testUpdateLruCacheHistory() {
        String[] testCacheData = {"a", "data1"};

        LruCache lruCache = new LruCache();

        assertTrue(lruCache.addCacheMemory(testCacheData[0], testCacheData[1]));
        assertEquals(testCacheData[1], lruCache.getCacheMemory(testCacheData[0]).getValue());

        assertNotNull(lruCache.getCacheMemory(testCacheData[0]).getHistory());
    }
}
