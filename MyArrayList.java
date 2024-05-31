package modul9.myArrayList;





public class MyArrayList  {

    private Object[] elementData;
    private static final int DEFAULT_CAPACITY = 10;
    private int size ;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public String toString() {
         StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < elementData.length; i++) {
            sb.append(elementData[i]);
            if (i + 1 < elementData.length&&elementData[i+1]!=null) {
                sb.append(",");
            }
            if (elementData[i+1]==null) {
                sb.append("]");
                return sb.toString();
            }
        }
        sb.append("]");
        return sb.toString();
    }



    public void add(Object o) {



        if (size == elementData.length){
            System.out.println(-1);
        }

        elementData[size++] = o;


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
        public Object get(int index){
            if (index<0||index>=size){
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            return elementData[index];
        }


    }









