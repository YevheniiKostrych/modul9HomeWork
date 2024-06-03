package modul9.myQueue;
public class MyQueue <T> {
    transient Node<T> head;
    transient Node<T> tail;
    private int size;
    public MyQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }public void add(T t) {
        MyQueue.Node<T> newNode = new MyQueue.Node<>(t);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {

                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
    }
  public  T peek(){
        if (head!=null){
      MyQueue.Node<T> current = head;
        return current.value;}
        else return null;
  }
   public T poll(){
       if (head!=null){
           MyQueue.Node<T> current = head;

          T result= current.value;
           head = head.next;
           size--;
           return  result;
       }
       else
           return null;
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
        MyQueue.Node current = head;
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
}