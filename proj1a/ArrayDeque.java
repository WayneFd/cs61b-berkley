public class ArrayDeque <T> {

    private T[] deque;
    private int size;
    private int nextlast;
    private int nextfirst;
    /* create empty ArrayDeque */
    public ArrayDeque() {
        deque = (T []) new Object[8];
        size = 0;
        nextlast = 0;
        nextfirst = deque.length -1;
    }
    /* resize the length of the item */
    public void resize(int capacity) {
        T[] newdeque= (T []) new Object[capacity];
        for (int i =1; i <= size; i++) {
            int index = (nextfirst + i) % deque.length;
            newdeque[i-1] = deque[index];
        }
        nextfirst = newdeque.length-1;
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
        nextfirst -= 1;
    }

    /* adds an item to the back of the deque */
    public void addLast(T item) {
        if (size == deque.length) {
            resize( 2 * size );
        }
        deque[nextlast] = item;
        size += 1;
        nextlast += 1;
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
        for (int i = 1 ; i < size; i++) {
            int index = (nextfirst + i) % deque.length;
            System.out.print((String)deque[index] + ' ');
        }
        System.out.print('\n');

    }

    /* remove the first item and return the value */
    public T removeFirst() {
        int index = (nextfirst + 1) % deque.length;
        T remove = deque[index];
        deque[index] = null;
        nextfirst += 1;
        if (nextfirst == deque.length) {
            nextfirst -= 1;
        }
        if (!isEmpty()) {
            size -= 1;
        }
        if ( size < 0.25 * deque.length) {
            resize((int)0.5 * deque.length);
        }
        return remove;
    }

    /* remove the last item and return the value  */
    public T removeLast() {
        int index = (nextlast - 1) %deque.length;
        T remove = deque[index];
        deque[index] = null;
        nextlast -= 1;
        if (nextlast == -1) {
          nextlast +=1;
        }
        if (!isEmpty()) {
            size -= 1;
        }
        if ( size < 0.25 * deque.length) {
            resize((int)0.5 * deque.length);
        }
        return remove;
    }

    /* get the item at the given index */
    public T get (int index ) {
        int p = (nextfirst + index +1) % deque.length;
        T item = deque[p];
        return  item;
    }




}

