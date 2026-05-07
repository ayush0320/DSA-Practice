package queues;
// https://youtu.be/va_6RmSrKCg

// Queue: FIFO (First In First Out) data structure
// Implementation of a queue using an array
// Time complexity:
// Enqueue: O(1)
// Dequeue: O(n) - because we need to shift all elements after removing the front element
// Peek: O(n) - because we need to access the front element which is at index 0

// ------------------------------------------------------------------------

public class ArrayQueue {
    static class Queue {
        static int arr[];
        static int size;
        static int rear = -1;

        // Constructor to initialize the queue
        Queue(int size) {
            arr = new int[size];
            this.size = size;
        }

        // 1. Check if the queue is empty
        public static boolean isEmpty() {
            return rear == -1;
        }

        // 2. ENQUEUE - Add an element to the rear of the queue
        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++; // Move rear to the next position
            arr[rear] = data; // Add the new element at the rear position
        }

        // 3. DEQUEUE - Remove an element from the front of the queue
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0]; // Store the front element to return later
            // Shift all elements to the left to fill the gap created by the removed element
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--; // Move rear back after shifting
            return front; // Return the removed element
        }

        // 4. PEEK - Get the front element of the queue without removing it
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0]; // Return the front element
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6); // This will show "Queue is full"

        System.out.println(q.remove()); // Output: 1
        System.out.println(q.peek()); // Output: 2
    }

}
