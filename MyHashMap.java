package modul9.myHashMap;
import java.util.Objects;
public class MyHashMap<K,V>{
    private static final int DEFAULT_SIZE=8;
    private int size=0;
    private Entry<K,V>[] context=new Entry[DEFAULT_SIZE];
    public void put(K key,V value){
        int index=calculateIndex(key);
        Entry<K,V>newEntry=new Entry<>(key,value);
        if (context[index]==null){
            context[index]=newEntry;
        } else {
            Entry<K, V> current = context[index];
            while (current != null) {
                if (key == null) {
                    if (key==null) ;
                    current.value = value;
                    return;}
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = newEntry;
        }
        size++;
    }
    public V get (K key ){
        int index =calculateIndex(key);
        Entry<K, V> current = context[index];

        while (current != null) {
            if (key == null) {
                return current.value ;}
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    public void remove(K key){
       int index =calculateIndex(key);
       Entry<K, V> current = context[index];
       Entry<K, V> previous = null;
       while (current != null) {
           if ((Objects.equals(current.key, key))) {
               if (previous == null) {
                   context[index] = current.next;
               } else {
                   previous.next = current.next;
               }
               size--;
               return;
           }
           previous = current;
           current = current.next;
       }
   }
    public int size() {
        return size;
    }
    public void clear() {
        context = new Entry[DEFAULT_SIZE];
        size = 0;
    }
    private int calculateIndex(K key){
        return key == null ? 0 : Math.abs(key.hashCode() % context.length);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;

        for (Entry<K, V> entry : context) {
            while (entry != null) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(entry.key).append("=").append(entry.value);
                first = false;
                entry = entry.next;
            }
        }
        sb.append("}");
        return sb.toString();
    }
    static class Entry <K,V>{
        K key;
        V value;
        Entry <K,V> next;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
