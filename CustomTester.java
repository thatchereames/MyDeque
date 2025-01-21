/**
 * Name: Thatcher Eames
 * PID: A17284279
 * Sources Used: Write-up, Public Tester file, CSE 12 Style Guide
 * 
 * This file is used to create a generic Deque class that implements the Deque
 * interface.
 */
import org.junit.Test;
import static org.junit.Assert.*;


public class CustomTester {
    /**
     * Helper method to initialize all instance variables of MyDeque
     * @param deque The deque to initialize
     * @param data The data array
     * @param size The value for size
     * @param front The value for front
     * @param rear The value for rear
     */
    static void initDeque(MyDeque<Integer> deque, Object[] data, int size,
                          int front, int rear) {
        deque.data = data;
        deque.size = size;
        deque.front = front;
        deque.rear = rear;
    }

    @Test
    public void testMyDequeConstructor() {
        Integer[] nullData = {null, null, null, null, null};
        assertThrows(IllegalArgumentException.class , () -> 
            {new MyDeque<Integer>(-5);});
        MyDeque<Integer> deque = new MyDeque<>(5);
        assertArrayEquals(deque.data , nullData);
        assertEquals(0 , deque.size);
        assertEquals(0 , deque.front);
        assertEquals(0 , deque.rear);
    }

    @Test
    public void testExpandCapacity() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] orig = {4, null, 1, 2, 3};
        initDeque(deque, orig, 4, 2, 0);
        deque.expandCapacity();
        Integer[] expected = {1, 2, 3, 4, null, null, null, null, null, null};
        assertArrayEquals(expected, deque.data);
        assertEquals(0, deque.front);
        assertEquals(3, deque.rear);
    }

    @Test
    public void testAddFirst() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] orig = {4, null, 1, 2, 3};
        initDeque(deque, orig, 4, 2, 0);
        assertThrows(NullPointerException.class , 
            () -> {deque.addFirst(null);});
        deque.addFirst(5);
        Integer[] expected1 = {4, 5, 1, 2, 3};
        assertArrayEquals(expected1, deque.data);
        assertEquals(1, deque.front);
        assertEquals(0, deque.rear);
        deque.addFirst(6);
        Integer[] expected2 = {5, 1, 2, 3, 4, null, null, null, null, 6};
        assertArrayEquals(expected2, deque.data);
        MyDeque<Integer> zeroDeque = new MyDeque<>(0);
        zeroDeque.addFirst(0);
        Integer[] expected3 = 
        {0, null, null, null, null, null, null, null, null, null};
        assertArrayEquals(expected3, zeroDeque.data);
        assertEquals(0, zeroDeque.front);
        assertEquals(0, zeroDeque.rear);
    }

    @Test
    public void testAddLast() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] orig = {4, null, 1, 2, 3};
        initDeque(deque, orig, 4, 2, 0);
        assertThrows(NullPointerException.class , 
            () -> {deque.addLast(null);});
        deque.addLast(5);
        Integer[] expected1 = {4, 5, 1, 2, 3};
        assertArrayEquals(expected1, deque.data);
        assertEquals(2, deque.front);
        assertEquals(1, deque.rear);
        deque.addLast(6);
        Integer[] expected2 = {1, 2, 3, 4, 5, 6, null, null, null, null};
        assertArrayEquals(expected2, deque.data);
        MyDeque<Integer> zeroDeque = new MyDeque<>(0);
        zeroDeque.addFirst(0);
        Integer[] expected3 = 
        {0, null, null, null, null, null, null, null, null, null};
        assertArrayEquals(expected3, zeroDeque.data);
        assertEquals(0, zeroDeque.front);
        assertEquals(0, zeroDeque.rear);
    }

    @Test
    public void testRemoveFirst() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] orig = {4, null, 1, 2, 3};
        initDeque(deque, orig, 4, 2, 0);
        deque.removeFirst();
        Integer[] expected1 = {4, null, null, 2, 3};
        assertArrayEquals(expected1, deque.data);
        assertEquals(3, deque.front);
        deque.removeFirst();
        deque.removeFirst();
        assertEquals(0, deque.front);
        deque.removeFirst();
        Integer[] expected2 = {null, null, null, null, null};
        assertArrayEquals(expected2, deque.data);
    }

    @Test 
    public void testRemoveLast() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] orig = {4, null, 1, 2, 3};
        initDeque(deque, orig, 4, 2, 0);
        deque.removeLast();
        Integer[] expected1 = {null, null, 1, 2, 3};
        assertArrayEquals(expected1, deque.data);
        assertEquals(4, deque.rear);
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        Integer[] expected2 = {null, null, null, null, null};
        assertArrayEquals(expected2, deque.data);
    }

    @Test
    public void testMyStack() {
        MyStack<Integer> stack = new MyStack<>(0);
        assertTrue(stack.empty());
        stack.push(0);
        assertEquals(1, stack.size());
        assertEquals(0, (Object) stack.pop());
        assertTrue(stack.empty());
        stack.push(1);
        stack.push(2);
        assertEquals(2, (Object) stack.peek());
        assertFalse(stack.empty());
        assertEquals(2, stack.size());
    }

    @Test
    public void testMyQueue() {
        MyQueue<Integer> q = new MyQueue<>(0);
        assertTrue(q.empty());
        q.enqueue(0);
        assertEquals(0, (Object) q.peek());
        assertEquals(0, (Object) q.dequeue());
        assertEquals(0, q.size());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(3, q.size());
        assertEquals(1, (Object) q.dequeue());
        assertEquals(2, (Object) q.peek());
        assertFalse(q.empty());
    }
}
