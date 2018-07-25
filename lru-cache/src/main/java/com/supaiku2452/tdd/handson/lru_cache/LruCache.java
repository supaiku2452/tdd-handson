package com.supaiku2452.tdd.handson.lru_cache;

import java.util.*;

public class LruCache {

    Map<String, CacheMemory> lruCacheMemoryMap = new TreeMap<>();
    private static int addedNumberCounter = 0;
    
    public boolean add(String key, String value) {

        if ( lruCacheMemoryMap.size() == 3 ) {
            // 全てNullかチェックする必要がある
            long unuseDataCount = lruCacheMemoryMap.entrySet().stream()
                    .filter(entry -> entry.getValue().getHistory() == null)
                    .count();

            if ( unuseDataCount == 3 || unuseDataCount == 0 ) {
                boolean isFirst = true;

                Map<String, CacheMemory> _lruCacheMemoryMap = new TreeMap<>();

                for ( Iterator<Map.Entry<String, CacheMemory>> it = lruCacheMemoryMap.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry<String, CacheMemory> entry = it.next();

                    if ( isFirst ) {
                        isFirst = false;
                    } else {
                        _lruCacheMemoryMap.put(entry.getKey(), entry.getValue());
                    }
                }
                lruCacheMemoryMap = new TreeMap<>(_lruCacheMemoryMap);
                lruCacheMemoryMap.put(key, new CacheMemory(value, addedNumberCounter++));
            } else {
                Map<String, CacheMemory> _lruCacheMemoryMap = new TreeMap<>();
                lruCacheMemoryMap.entrySet().stream()
                        .filter(entry -> entry.getValue().getHistory() != null)
                        .forEach(entry -> _lruCacheMemoryMap.put(entry.getKey(), entry.getValue()));

                lruCacheMemoryMap = new TreeMap<>(_lruCacheMemoryMap);
                lruCacheMemoryMap.put(key, new CacheMemory(value, addedNumberCounter++));
            }
        } else {
            lruCacheMemoryMap.put(key, new CacheMemory(value, addedNumberCounter++));
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

    public String getFirstAddedData() {
        return this.lruCacheMemoryMap.entrySet().stream()
                .sorted((o1, o2) -> (o1.getValue().getAddedNumber() - o2.getValue().getAddedNumber()))
                .findFirst()
                .get()
                .getKey();
    }

    public class CacheMemory {
        private final String value;
        private Date history;

        private int addedNumber;

        @Override
        public String toString() {
            return this.getValue();
        }

        public CacheMemory(String value, int addedNumber) {
            this.addedNumber = addedNumber;
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

        public int getAddedNumber() {
            return addedNumber;
        }
    }
}
