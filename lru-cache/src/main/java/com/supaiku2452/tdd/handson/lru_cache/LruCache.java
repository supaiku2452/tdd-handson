package com.supaiku2452.tdd.handson.lru_cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LruCache {
    Map<String, String> lruCacheMap = new HashMap<>();

    public boolean add(String key, String value) {

        if ( lruCacheMap.size() == 3 ) {
            boolean isFirst = true;

            Map<String, String> _lruCacheMap = new HashMap<>();
            for ( Iterator<Map.Entry<String, String>> it = this.lruCacheMap.entrySet().iterator(); it.hasNext(); ) {
                // iteratorを必ず進める
                Map.Entry<String, String> entry = it.next();

                // とりあえず最初の要素を除外する
                if ( isFirst ) {
                    isFirst = false;
                } else {
                    _lruCacheMap.put(entry.getKey(), entry.getValue());
                }
            }
            lruCacheMap = new HashMap<>(_lruCacheMap);
            lruCacheMap.put(key, value);
        } else {
            lruCacheMap.put(key, value);
        }

        return true;
    }

    public String get(String key) {
        return lruCacheMap.get(key);
    }
}
