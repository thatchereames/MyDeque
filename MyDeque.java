/**
 * Name: Thatcher Eames
 * PID: A17284279
 * Sources Used:
 * 
 * This file is used to create a generic Deque class that implements the Deque
 * interface.
 */

/**
 * This class stores data in a deque style format. It can add data to top or
 * bottom as well as ad
 * 
 * Instance variables:
 * data - An array holding the variables stored in MyDeque
 * size - The number of data points currently held in MyDeque
 * rear - The index of the last element
 * front - The index of the first element
 */
public class MyDeque<E> implements DequeInterface<E> {
    Object[] data;
    int size;
    int rear;
    int front;

    public static final int DEFAULT_CAPACITY = 10;

    public MyDeque(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        data = new Object[initialCapacity];
        size = 0;
        rear = 0;
        front = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void expandCapacity() {
        Object newData[];
        if(data.length == 0) {
            data = new Object[DEFAULT_CAPACITY];
            return;
        } else {
            newData = new Object[data.length * 2];
        }
        int dataIdx = front;
        for (int i = 0; i < size; i++) {
            if (dataIdx == data.length) {
                dataIdx = 0;
            }
            newData[i] = data[dataIdx];
            dataIdx++;
        } 
        data = newData;
        front = 0;
        rear = size - 1;
    }

    @Override
    public void addFirst(E element) {
        if (element == null) {
            throw new NullPointerException();
        } else if (size >= data.length || data.length == 0) {
            expandCapacity();
        }
        if(data[front] == null) {
            data[front] = element;
        } else if(front == 0) {
            data[data.length - 1] = element;
            front = data.length - 1;
        } else {
            data[front - 1] = element;
            front--;
        }
        size++;
    }

    @Override
    public void addLast(E element) {
        if (element == null) {
            throw new NullPointerException();
        } else if (size >= data.length || data.length == 0) {
            expandCapacity();
        }
        if(data[rear] == null){
            data[rear] = element;
        } else if (rear == data.length - 1) {
            data[0] = element;
            rear = 0;
        } else {
            data[rear + 1] = element;
            rear++;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        //Stores the value of the first element while it is removed
        if (size == 0 ) return null;
        Object firstElement = data[front];
        data[front] = null;
        if (front != rear) {
            if (front == data.length - 1) {
                front = 0;
            } else {
                front++;
            }
        }
        size--;
        return (E) firstElement;
    }
    @Override
    public E removeLast() {
        if (size == 0) return null;
        Object lastElement = data[rear];
        data[rear] = null;
        if (rear != front){
            if (rear == 0) {
                rear = data.length - 1;
            } else {
                rear--;
            }
        }
        size--;
        return (E) lastElement;
    }

    @Override
    public E peekFirst() {
        if (size == 0) return null;
        return (E) data[front];
    }

    @Override
    public E peekLast() {
        if (size == 0) return null;
        return (E) data[rear];
    }
}