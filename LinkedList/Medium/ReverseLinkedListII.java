// LC 92. Reverse Linked List II

// Pattern:
// 1. Reverse a portion of the linked list between positions m and n
// 2. Pointer manipulation to reverse the sublist in place
// 3. Dummy node

// ------------------------------------------------------------------------

import java.util.List;

public class ReverseLinkedListII {
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
    // Take nodes one by one and move them to the front of the sublist
    // 1. Create a dummy node and point it to the head of the list
    // 2. Move a pointer to the node before the left position
    // 3. Reverse the sublist between left and right by adjusting pointers
    // Take next node → remove it → insert after prev

    // Time Complexity: O(n) where n is the length of the linked list
    // Space Complexity: O(1) no extra space used

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head; // list is empty or left and right are the same
        }

        ListNode dummy = new ListNode(0); // Create a dummy node
        dummy.next = head; // Point dummy to the head of the list

        ListNode prev = dummy; // Initialize prev to dummy
        for (int i = 1; i < left; i++) {
            prev = prev.next; // Move prev to the node before the left position
        }

        ListNode curr = prev.next; // Start of the sublist to reverse

        // Reverse the sublist between left and right
        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next; // Return the new head of the list
    }

    // --------------------

    public static void main(String[] args) {
        ReverseLinkedListII solution = new ReverseLinkedListII();

        int[] arr = { 1, 2, 3, 4, 5 };
        ListNode head = solution.createLinkedList(arr);
        System.out.println("Original List:");
        solution.printLinkedList(head);

        int left = 2, right = 4;
        ListNode modifiedHead = solution.reverseBetween(head, left, right);
        System.out.println("Modified List:");
        solution.printLinkedList(modifiedHead);

    }

}