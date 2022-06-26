public class LinkedListDeque<Item> implements Deque<Item> {

    private IntNode seninel;
    private int size;

    public class IntNode {
        public Item item;
        public IntNode next;
        public IntNode prev;
        public IntNode(IntNode prev, Item item, IntNode next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }


    public LinkedListDeque(){
        seninel = new IntNode(null, null, null);
        size = 0;

    }
    @Override
    /** add the first Item to the double-linked list */
    public void addFirst(Item item) {
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
    @Override
    /** add the last Item to the list */
    public void addLast(Item item) {
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
    @Override
    public boolean isEmpty() {
        return seninel.next == null;
    }

    @Override
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

    @Override
    /** remove and return the first Item at the deque */
    public Item removeFirst() {
        /**
         * seems not necessary
            if (size == 1) {
            IntNode l = seninel.next;
            seninel.next = null;
            return l.item;
        }*/
        IntNode f = seninel.next;
        f.next.prev = f.prev;
        seninel.next = f.next;
        f.prev.next = f.next;
        f.next = null;
        f.prev = null;
        size--;
        return f.item;
    }

    @Override
    /** remove and return the last Item at the deque*/
    public Item removeLast() {
        IntNode l = seninel.next.prev;
        seninel.next.prev = l.prev;
        l.prev.next = l.next;
        l.prev = null;
        l.next = null;
        size--;
        return l.item;
    }

    @Override
    /** get the Item at the given index */
    public Item get(int index) {
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
        p.addLast(0);

        p.size();
        p.removeFirst();
        p.removeLast();
        p.printDeque();

    }




}
