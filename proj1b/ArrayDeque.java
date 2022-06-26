public class ArrayDeque<Item> {
    private Item[] dArray;
    private int capacity = 8;
    private int size;
    private int left;
    private int right;
    private Item items;
    public ArrayDeque(){
        size = 0;
        dArray = (Item[]) new Object[capacity];
        left = 0;
        right = 1;
    }

    public void addFirst(Item T) {
        resize(dArray.length);
        dArray[left] = T;
        size++;
        left = Math.floorMod(left-1, dArray.length);

    }


    public void addLast(Item T) {
        dArray[right] = T;
        size++;
        right = Math.floorMod(right+1, dArray.length); /* floormod() makes it possible that the @para right is within
         the range of the size */
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size(){
        return size;
    }

    public void printDeque() {

        System.out.println();   /* 'sout' for acronym */
    }

    public void resize(int length) {
        if (size == dArray.length) {
            Item[] temp = dArray;
            length = dArray.length*2;
            dArray = (Item[]) new Object[length];
            for (int i=0; i<size; i++) {
                dArray[i] = temp[i];
            }
            left += length/2;
            right += length/2;
            capacity = length;


        }
    }
    public static void main(String[] args) {
        ArrayDeque<Integer> p = new ArrayDeque();
        p.addFirst(1);
        p.addFirst(2);
        p.addFirst(3);
        p.addFirst(4);
        p.addFirst(5);
        p.addLast(0);
        p.addFirst(6);
        p.addFirst(7);
        p.addFirst(8);
        p.addFirst(9);

    }








}
