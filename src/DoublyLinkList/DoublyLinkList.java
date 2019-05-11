package DoublyLinkList;

public class DoublyLinkList {

    private static class Node {

        private String data;
        private Node next;
        private Node prev;

        public Node(String data) {
            this.data = data;
        }

        public void displayNode() {
            System.out.print(data + " ");
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public Node first = null;
    public Node last = null;

    public void addFirst(String data) {

        Node newNode = new Node(data);

        if (isEmpty()) { // если first = null
            newNode.next = null;
            newNode.prev = null;
            first = newNode;
            last = newNode;

        } else {
            first.prev = newNode;
            newNode.next = first;
            newNode.prev = null;
            first = newNode;
        }
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void displayList() {
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    public void removeFirst() {
        if (!isEmpty()) {
            Node temp = first;

            if (first.next == null) {
                first = null;
                last = null;
            } else {
                first = first.next;
                first.prev = null;
            }
            System.out.println(temp.toString() + " is popped from the list");
        }
    }

    public static void main(String[] args) {
        DoublyLinkList doublyLinkList = new DoublyLinkList();
        doublyLinkList.addFirst("111");
        doublyLinkList.addFirst("222");
        doublyLinkList.addFirst("333");
        doublyLinkList.displayList();


    }

    public void removeLast() {
        Node temp = last;

        if (!isEmpty()) {

            if (first.next == null) {
                first = null;
                last = null;
            } else {
                last = last.prev;
                last.next = null;
            }
        }
        System.out.println(temp.toString() + " is popped from the list");
    }
}
