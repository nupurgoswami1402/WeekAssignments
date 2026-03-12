import java.util.*;

class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private int capacity;

    LRUCache(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > capacity;
    }
}

class week2_5 {

    LRUCache<String,String> L1 = new LRUCache<>(10000);
    LRUCache<String,String> L2 = new LRUCache<>(100000);

    public String getVideo(String id) {

        if(L1.containsKey(id))
            return L1.get(id);

        if(L2.containsKey(id)) {
            String v = L2.get(id);
            L1.put(id,v);
            return v;
        }

        String v = queryDatabase(id);
        L2.put(id,v);
        return v;
    }

    private String queryDatabase(String id){
        return "VideoData_"+id;
    }
}