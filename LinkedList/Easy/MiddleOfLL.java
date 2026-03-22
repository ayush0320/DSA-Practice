// LC 876. Middle of the Linked List

// https://youtu.be/7LjQ57RqgEc

// Pattern: Tortoise and Hare (Fast & Slow Pointer) Pattern
// 1. Two pointers: slow and fast
// 2. Slow moves 1 step at a time
// 3. Fast moves 2 steps at a time
// 4. When fast reaches the end, slow will be at the middle

// .data - to store the value of the node

// ------------------------------------------------------------------------

public class MiddleOfLL {

    class ListNode {
        int data;
        ListNode next;

        ListNode(int x) {
            this.data = x;
            this.next = null;
        }
    }

    // Helper function: Create linked list from array
    public ListNode createLinkedList(int[] arr) {
        if (arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Print the linked list
    public void printLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // --------------------

    // Middle of the Linked List using Fast & Slow Pointer
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // move slow by 1 step
            fast = fast.next.next; // move fast by 2 steps
        }
        return slow; // slow will be at the middle when fast reaches the end
    }
    // --------------------

    public static void main(String[] args) {
        MiddleOfLL solution = new MiddleOfLL();

        int[] arr = { 1, 2, 3, 4, 5 };

        // Create the linked list from the array
        ListNode head = solution.createLinkedList(arr);

        System.out.println("Original List:");
        solution.printLinkedList(head); // Print the original linked list

        System.out.println("Middle node: " + solution.middleNode(head).data);
    }

}
