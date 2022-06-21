public class LinkedListDeque<item> {

    private IntNode seninel;
    private int size;

    public class IntNode {
        public item item;
        public IntNode next;
        public IntNode prev;
        public IntNode(IntNode prev, item item, IntNode next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }


    private LinkedListDeque(){
        seninel = new IntNode(null, null, null);
        size = 0;

    }

    /** add the first item to the double-linked list */
    public void addFirst(item item) {
        IntNode p = new IntNode(null, item, null);
        if (isEmpty()) {
            seninel.next = p;
            p.prev = p;
            size++;
            return;
        }
        p.prev = seninel.next.prev;
        p.next = seninel.next;
        p.next.prev = p;
        seninel.next = p;

        size++;
    }
    /** add the last item to the list */
    public void addLast(item item) {
        IntNode p = new IntNode(null, item, null);
        if (isEmpty()) {
            seninel.next = p;
            p.prev = p;
            size++;
            return;
        }
        p.prev = seninel.next.prev;
        p.prev.next = p;
        seninel.next.prev = p;
        p.next = seninel.next;

        size++;
    }

    private boolean isEmpty() {
        return seninel.next == null;
    }

    /** return the size of the list */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque() {
        IntNode p = seninel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /** remove and return the first item at the deque */
    public item removeFirst() {
        IntNode f = seninel.next;
        f.next.prev = f.prev;
        seninel.next = f.next;
        f.next = null;
        f.prev = null;
        size--;
        return seninel.next.item;
    }

    /** remove and return the last item at the deque*/
    public item removeLast() {
        IntNode l = seninel.next.prev;
        seninel.next.prev = l.prev;
        l.prev.next = l.next;
        l.prev = null;
        l.next = null;
        size--;
        return seninel.next.item;
    }

    /** get the item at the given index */
    public item get(int index) {
        IntNode p = seninel.next;
        while (index != 0){
            p = p.next;
            index--;
        }
        return p.item;
    }


    public static void main(String[] args) {
        LinkedListDeque<Integer> p = new LinkedListDeque() ;
        p.addFirst(1);
        p.addFirst(2);
        p.addFirst(3);
        p.addFirst(4);
        p.addFirst(5);
        p.addLast(0);

        p.size();
        p.removeFirst();
        p.removeLast();
        p.printDeque();

    }




}
