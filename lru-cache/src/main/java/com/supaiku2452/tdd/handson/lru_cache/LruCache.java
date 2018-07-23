package com.supaiku2452.tdd.handson.lru_cache;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LruCache {

    Map<String, CacheMemory> lruCacheMemoryMap = new HashMap<>();

    public boolean add(String key, String value) {

        if ( lruCacheMemoryMap.size() == 3 ) {
            boolean isFirst = true;

            Map<String, CacheMemory> _lruCacheMemoryMap = new HashMap<>();
            for ( Iterator<Map.Entry<String, CacheMemory>> it = lruCacheMemoryMap.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<String, CacheMemory> entry = it.next();

                if ( isFirst ) {
                    isFirst = false;
                } else {
                    _lruCacheMemoryMap.put(entry.getKey(), entry.getValue());
                }
            }
            lruCacheMemoryMap = new HashMap<>(_lruCacheMemoryMap);
            lruCacheMemoryMap.put(key, new CacheMemory(value));
        } else {
            lruCacheMemoryMap.put(key, new CacheMemory(value));
        }

        return true;
    }

    public CacheMemory get(String key) {
        if ( lruCacheMemoryMap.get(key) == null ) {
            return null;
        }
        lruCacheMemoryMap.get(key).setHistory(new Date());
        return lruCacheMemoryMap.get(key);
    }

    public class CacheMemory {
        private final String value;
        private Date history;

        public CacheMemory(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setHistory(Date history) {
            this.history = history;
        }

        public Date getHistory() {
            return history;
        }
    }
}
