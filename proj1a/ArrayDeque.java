public class ArrayDeque<T> {

    private T[] deque;
    private int size;
    private int nextlast;
    private int nextfirst;

    /* add one to realize circular array */
    private int plusone(int index) {
        return (index + 1) % deque.length;
    }

    /* minus one to realize circular array */
    private int minusone(int index) {
        return (index - 1 + deque.length) % deque.length;
    }
    /* create empty ArrayDeque */
    public ArrayDeque() {
        deque = (T []) new Object[8];
        size = 0;
        nextlast = 0;
        nextfirst = deque.length - 1;
    }
    /* resize the length of the item */
    private void resize(int capacity) {
        T[] newdeque = (T []) new Object[capacity];
        for (int i = 1; i <= size; i++) {
            int index = (nextfirst + i) % deque.length;
            newdeque[i - 1] = deque[index];
        }
        nextfirst = newdeque.length - 1;
        nextlast = size;
        deque = newdeque;

    }
    /* add an item to the front of the deque  */
    public void addFirst(T item) {
        if (size == deque.length) {
            resize(2 * size);
        }
        deque[nextfirst] = item;
        size += 1;
        nextfirst = minusone(nextfirst);
    }

    /* adds an item to the back of the deque */
    public void addLast(T item) {
        if (size == deque.length) {
            resize(2 * size);
        }
        deque[nextlast] = item;
        size += 1;
        nextlast = plusone(nextlast);
    }

    /* return true if the deque is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /* return the size of the deque */
    public int size() {
        return size;
    }

    /* prints the items in the deque from first to last */
    public void printDeque() {
        for (int i = 1; i <= size; i++) {
            int index = (nextfirst + i) % deque.length;
            System.out.print((String) deque[index] + ' ');
        }
        System.out.print('\n');

    }

    /* remove the first item and return the value */
    public T removeFirst() {
        if (size < deque.length / 4 && deque.length > 16) {
            resize(deque.length / 2);
        }
        int index = plusone(nextfirst);
        T remove = deque[index];
        deque[index] = null;
        nextfirst = plusone(nextfirst);
        if (!isEmpty()) {
            size -= 1;
        }
        return remove;
    }

    /* remove the last item and return the value  */
    public T removeLast() {
        if (size < deque.length / 4 && deque.length > 16) {
            resize(deque.length / 2);
        }
        int index = minusone(nextlast);
        T remove = deque[index];
        deque[index] = null;
        nextlast = minusone(nextlast);
        if (!isEmpty()) {
            size -= 1;
        }

        return remove;
    }

    /* get the item at the given index */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int p = (nextfirst + index + 1) % deque.length;
        T item = deque[p];
        return  item;
    }


}

