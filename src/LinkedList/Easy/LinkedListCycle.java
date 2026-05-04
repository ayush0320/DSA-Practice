// LC 141. Linked List Cycle

// Pattern: Tortoise and Hare (Fast & Slow Pointer) Pattern
// 1. Two pointers: slow and fast
// 2. Slow moves 1 step at a time
// 3. Fast moves 2 steps at a time
// 4. When fast reaches the end, slow will be at the middle

// Core idea: If there is a cycle in the linked list, 
// the fast pointer will eventually catch up to the slow pointer.

// ------------------------------------------------------------------------

import java.util.HashSet;

public class LinkedListCycle {

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

    // Brute Force Approach: HashSet to track visited nodes
    // HashSet:
    // • Stores only unique elements
    // • No duplicates allowed
    // • Fast lookups (O(1) average time complexity) and uniqueness
    // • O(1) time complexity for add and contains operations
    // Time complexity: O(n) where n is the number of nodes in the linked list
    // Space complexity: O(n) in the worst case (when there is no cycle)

    public boolean hasCycle1(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();

        ListNode curr = head;

        while (curr != null) {
            if (visited.contains(curr)) {
                return true;
            }

            visited.add(curr);
            curr = curr.next;
        }

        return false;

    }

    // --------------------

    // Fast & Slow Pointer Approach (Tortoise & Hare)
    // Middle of the Linked List method can be used to detect cycle as well

    public boolean hascycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // move slow by 1 step
            fast = fast.next.next; // move fast by 2 steps

            if (slow == fast) {
                return true; // cycle detected
            }
        }
        return false; // no cycle
    }

    // --------------------

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        int[] arr = { 1, 2, 3, 4, 5 };

        ListNode head = solution.createLinkedList(arr);

        // Create a cycle for testing
        head.next.next.next.next = head.next; // Create a cycle (5 -> 2)

        // Check for cycle
        // System.out.println(solution.hasCycle1(head));
        System.out.println(solution.hascycle2(head));

    }

}
