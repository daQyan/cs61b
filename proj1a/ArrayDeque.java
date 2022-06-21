public class ArrayDeque<item> {
    private item[] dArray;
    private int size;
    private int left;
    private int right;
    private item items;
    public ArrayDeque(){
        dArray = (item[]) new Object[size];
        size = 8;
        left = 4;
        right = 5;
    }

    public void addFirst(item T) {
        dArray[left] = T;
        left--;

    }

    public void addRight(item T) {
        dArray[right] = T;
        right--;
    }









}
