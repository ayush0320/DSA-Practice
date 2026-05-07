package queues;
//https://youtu.be/va_6RmSrKCg?t=961

// Circular Queue using Array

// ------------------------------------------------------------------------

public class CircularQueueArray {
    static class Queue {
        int arr[];
        int size;
        int rear = -1;
        int front = -1;

        Queue(int n) {
            arr = new int[n];
            this.size = n;
        }

        // 1. isEmpty
        public static boolean isEmpty(Queue q) {
            return q.front == -1 && q.rear == -1;
        }

        // 2. isFull
        public static boolean isFull(Queue q) {
            return (q.rear + 1) % q.size == q.front;
        }

        // 3. Enqueue
        public static void enqueue(Queue q, int data) {
            if (isFull(q)) {
                System.out.println("Queue is full");
                return;
            }
            // if queue is empty
            if (isEmpty(q)) {
                q.front = 0;
            }
            // add data to the rear
            q.rear = (q.rear + 1) % q.size;
            q.arr[q.rear] = data;
        }
    }
}
