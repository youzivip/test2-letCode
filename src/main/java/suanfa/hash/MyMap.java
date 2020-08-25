package suanfa.hash;

import java.util.ArrayList;
import java.util.List;

public class MyMap<K,V> {
    K[] keys;
    Entry<K,V>[] entries;
    int size;
    int capcity = 16;

    public MyMap() {
        keys = (K[]) new Object[capcity];
        entries = new Entry[capcity];
        size = 0;
    }

    public boolean put(K k,V v){
        if(size<capcity){
            //1 计算k的hash值对应的下标
            int hash =  k.hashCode()%capcity;
            Entry entry = entries[hash];
            if(entry == null) {
                entry = new Entry();
                entry.k = k;
                entries[hash] = entry;
            }
            entry.put(v);

        }
        return true;
    }

    public V get(K k){
        //1 计算k的hash值对应的下标
        int hash =  k.hashCode()%capcity;
        Entry entry = entries[hash];
        if(entry == null) return null;
        else return (V) entry.values.get(0);
    }

    static class Entry<K,V >{
        K k;
        List<V> values;

        public Entry() {
            values = new ArrayList<>(8);
        }

        public boolean put(V v){
            if(values.size()<8){
                values.add(v);
            }
            return true;
        }

    }
}
