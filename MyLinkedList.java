package modul9.myLinkedList;

public class MyLinkedList <T>{
   transient MyLinkedList.Node<T> head;

    transient MyLinkedList.Node<T> tail;
    private int size ;
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }



    public void add(T t ){
        Node<T> newNode=new Node<>(t);
        if (head==null){
           head=newNode;
           tail=newNode;
        }else {

          tail.next=newNode;
          newNode.prev=tail;
          tail=newNode;


        }
    size++;
    }




    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

   public void remove(int index) {
       if (index < 0 || index >= size) {
           throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
       }

       Node<T> currentNode = head;

       if (index == 0) {

           head = head.next;
           if (head != null) {
               head.prev = null;
           } else {

               tail = null;
           }
       } else {
           for (int i = 0; i < index; i++) {
               currentNode = currentNode.next;
           }
           currentNode.prev.next = currentNode.next;
           if (currentNode.next != null) {
               currentNode.next.prev = currentNode.prev;
           } else {

               tail = currentNode.prev;
           }
       }

       size--;
   }

    public int size() {
        return size;
    }
    public void clear() {

        head = null;
        tail = null;
        size = 0;

    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node<T>{
        private T value;
        private Node<T> next;

       private Node<T> prev;




       public Node(T value){
            this.value=value;}


        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }
    }

    }





