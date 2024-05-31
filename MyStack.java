package modul9.myStack;



public class MyStack  <T> {


    transient Node<T> top;
    private int size;

    public MyStack() {

        this.top = null;
        this.size = 0;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;




        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public void push(T t) {

        Node<T> newNode = new Node<>(t);

        newNode.next=top;
        top=newNode;

        size++;



    }
    public  Object peek(){
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.value;

    }
    public Object pop(){
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }


            Object result= top.value;

            top = top.next;
            size--;
            return result;
        }

    public int size() {
        return size;
    }
    public void clear() {

        top = null;
        size = 0;

    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            top = top.next;
        } else {
            Node <T>current = top;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node current = top;
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

