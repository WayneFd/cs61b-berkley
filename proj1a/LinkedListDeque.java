public class LinkedListDeque<T> {
    /* decide to use a circular sentinel */
    private TNode sentinel;
    private int size;

    /* design a private class */
    private class TNode  {
        private T item;
        private TNode prev;
        private TNode next;

        TNode(T i, TNode p, TNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    /* create a empty list */
    /* if there exit item, the first item should be sentinel.next */
    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

    }

    /* add an item in front of the deque */
    public void addFirst(T item) {
        TNode oldfirst = sentinel.next;
        sentinel.next = new TNode(item, sentinel, sentinel.next);
        oldfirst.prev = sentinel.next;
        size += 1;
    }

    /* add an item at the last of the deque */
    public void addLast(T item) {
        TNode oldlast = sentinel.prev;
        sentinel.prev = new TNode(item, sentinel.prev, sentinel);
        oldlast.next = sentinel.prev;
        size += 1;
    }

    /* return true if the list is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int s = size;
        TNode p = sentinel.next;
        while (s > 1) {
            System.out.print((String) p.item + ' ');
            p = p.next;
            s -= 1;
        }
        System.out.print((String) p.item + "\n");
    }


    public T removeFirst() {
        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        if (!isEmpty()) {
            size -= 1;
        }
        return  item;

    }

    public T removeLast() {
        T item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        if (!isEmpty()) {
            size -= 1;
        }
        return item;
    }

    public T get(int index) {
        if (index < 0 || index + 1 > size) {
            return null;
        }
        TNode p = sentinel.next;
        while (index > 0) {
            index -= 1;
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(TNode p, int index) {
        if (index == 0) {
            return p.item;
        } else {
            return getRecursive(p.next, index - 1);
        }
    }
    public T getRecursive(int index) {
        if (index < 0 || index + 1 > size) {
            return null;
        }
        return getRecursive(sentinel.next, index);
    }

}

