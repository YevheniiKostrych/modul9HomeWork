package modul9.myArrayList;
import java.util.Arrays;
public class MyArrayList <T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elementData ;
    private int size ;
    public MyArrayList() {
        elementData = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public void add(T t) {
            int oldCapacity=DEFAULT_CAPACITY;
      if (size == elementData.length){
           int newCapacity= (int) (oldCapacity*1.5);
           elementData= Arrays.copyOf(elementData,newCapacity);
        elementData[size++]=t;
        }
        else
            elementData[size++]=t;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i <size-1 ; i++) {
            elementData[i]=elementData[i+1];
        }
     elementData[--size]=null;
    }
    public void clear(){
        for (int i = 0; i < size; i++) {
            elementData[i]=null;
        }
        size=0;
    }
        public int size(){
        return size;
        }
        public T get(int index){
            if (index<0||index>=size){
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            return elementData[index];
        }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < elementData.length; i++) {
            sb.append(elementData[i]);
            if (i + 1< size) {
                sb.append(",");
            }
            if (i==size-1) {
                sb.append("]");
                return sb.toString();
            }
        }
        sb.append("]");
        return sb.toString();
    }
}









