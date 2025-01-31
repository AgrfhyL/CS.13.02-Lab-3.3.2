import java.util.Arrays;

public class CISQueue {

    // Array property.
    private Object[] arr;
    // Size property.
    private int size;
    // Index pointer. Indicates the tail of the most recently added element.
    private int tail;
    // Constructor.
    public CISQueue(int sizey) {
        arr = new Object[sizey];
        size = 0;
        tail = -1;
    }
    // Enqueue. This method adds a node to the end of the linked list.
    public void enqueue(Object data) {
        tail++;
        if (tail == arr.length) {
            Object[] original = arr;
            arr = Arrays.copyOf(original, original.length+1);
        }
        arr[tail] = data;
        size++;
    }
    // Dequeue. This method removes a node from the beginning of the linked list.
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object removed = arr[0];
        arr[0] = null;
        reshuffle();
        size--;
        tail--;
        return removed;
    }
    // isEmpty. Returns a boolean indicating whether the linked list is empty.
    public boolean isEmpty() {
        return size == 0;
    }
    // size. Returns the size of the queue.
    public int size() {
        int out = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null)
                break;
            out++;
        }
        return out;
    }
    // reshuffle. Moves each element down one tail. Called whenever we dequeue.
    public void reshuffle() {
        if (!isEmpty() && size != 1) {
            for (int i = 1; i < size; i++) {
                arr[i-1] = arr[i];
                if (i == size - 1) {
                    arr[i] = null;
                }
            }
        }
    }
    // toString. Returns a description of the queue in, for example, the following format:
    // CISQueue{queue=[7, 11], size=2, pointer=1}
    public String toString() {
        String out = "CISQueue{queue=[";
        for (int i = 0; i < arr.length; i++) {
            out += arr[i] + (i == arr.length-1 ? "" : ", ");
        }
        return out + "], size=" + size() + ", pointer=" + tail + "}";
    }
}
