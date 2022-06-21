public class SLList {
    public SLList() {

    }
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;


    public void addFirst(int x) {
        first = new IntNode(x, first);
    }


    public void insert(int item, int position) {
        if (first == null || position == 0) {
            addFirst(item);
            return;
        }

        IntNode curr = first;

        while (position != 1){
            curr = curr.next;
            position--;
        }

        curr.next = new IntNode(item, curr.next);

    }

    /** iteratively
     *
    public void reverse() {
        IntNode nextcurr = first;
        IntNode precurr = null;

        while (nextcurr != null) {
            IntNode curr = nextcurr.next;
            nextcurr.next = precurr;
            precurr = nextcurr;
            nextcurr = curr;

        }
        first = precurr;


    }*/

    //recursion
    public IntNode reverseHelp(IntNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        IntNode curr = reverseHelp(p.next);
        p.next.next = p;
        p.next = null;
        return curr;

    }

    public void reverse() {
        reverseHelp(first);
    }




    public static void main(String[] args) {
        SLList test = new SLList();
        test.addFirst(1);
        test.addFirst(2);
        test.addFirst(3);
        test.addFirst(4);
        test.reverse();
    }
}
