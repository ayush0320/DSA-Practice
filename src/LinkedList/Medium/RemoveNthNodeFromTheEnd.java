package linkedlist.medium;
// LC 19. Remove Nth Node From End of List
// https://youtu.be/XtYEEvrhemI
// https://youtu.be/1dW442I3xrI

// Pattern: Two Passes + Dummy Node Pattern
// 1. First pass: Calculate the length of the linked list
// 2. Second pass: Remove the (length - n)th node from the beginning
// 3. Dummy Node: A temporary node used to simplify edge cases in linked list operations

// ------------------------------------------------------------------------

public class RemoveNthNodeFromTheEnd {
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

    // Steps:
    // 1. Create dummy
    // 2. Move fast n+1 steps
    // 3. Move both pointers
    // 4. Delete slow.next

    // Time Complexity: O(L) where L is the length of the linked list
    // Space Complexity: O(1)

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy_head = new ListNode(0); // Create a dummy node
        dummy_head.next = head; // Point dummy to the head of the list

        // Initialize fast and slow pointer to dummy
        ListNode slow = dummy_head;
        ListNode fast = dummy_head;

        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end of the list
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy_head.next;
    }

    // --------------------

    public static void main(String[] args) {
        RemoveNthNodeFromTheEnd solution = new RemoveNthNodeFromTheEnd();
        int[] arr = { 1, 2, 3, 4, 5 };
        ListNode head = solution.createLinkedList(arr);
        System.out.println("Original list: ");
        solution.printLinkedList(head);
        int n = 2;
        ListNode modifiedList = solution.removeNthFromEnd(head, n);
        System.out.println("Modified list after removing " + n + "th node from the end: ");
        solution.printLinkedList(modifiedList);
    }

}
