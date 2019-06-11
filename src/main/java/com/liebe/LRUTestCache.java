package com.liebe;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUTestCache extends LinkedHashMap {

    private final int cacheSize;

    /**
     * true 让map按照访问顺序来进行排序 最近访问的放在头部 最老访问的放在尾部
     * @param cacheSize
     */
    public LRUTestCache(int cacheSize) {
        super((int) Math.ceil((cacheSize/0.75)+1), 0.75f, true);
        this.cacheSize = cacheSize;
    }

    /**
     * 当map中的数据量大于指定的缓存个数时，就自动删除最老的数据
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>cacheSize;
    }
}
