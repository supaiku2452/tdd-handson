package com.supaiku2452.tdd.handson.lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    Map<String, String> lruCacheMap = new HashMap<>();

    public boolean add(String key, String value) {
        lruCacheMap.put(key, value);
        return true;
    }

    public String get(String key) {
        return lruCacheMap.get(key);
    }
}
