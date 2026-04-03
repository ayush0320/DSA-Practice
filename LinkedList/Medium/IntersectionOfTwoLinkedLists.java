// Lc 160. Intersection of Two Linked Lists
// https://youtu.be/0DYoPz2Tpt4s

// Pattern: Two Pointers
// 1. Initialize two pointers, one for each linked list.
// 2. Move both pointers forward one step at a time.
// 3. If a pointer reaches the end of its linked list,
//    redirect it to the head of the other linked list.
// 4. If the two linked lists intersect,
//    the pointers will eventually meet at the intersection

// ------------------------------------------------------------------------

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {
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

    // Using hash set
    // 1. Traverse the first linked list and store each node in a hash set.
    // 2. Traverse the second linked list and check if any node is already in the
    // hash set.
    // 3. If a node from the second linked list is found in the hash set, return it.
    // 4. If the second linked list is fully traversed without finding any node in
    // the hash set,return null.

    // Time complexity: O(m + n), m and n are the lengths of two linked lists
    // Space complexity: O(m) where m is the length of the first linked list

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode currA = headA;
        while (currA != null) {
            set.add(currA);
            currA = currA.next;
        }

        ListNode currB = headB;
        while (currB != null) {
            if (set.contains(currB)) {
                return currB;
            }
            currB = currB.next;
        }
        return null;

    }

    // --------------------

    // Optimal approach: Two pointers
    // 1. Initialize two pointers, one for each linked list.
    // 2. Move both pointers forward one step at a time.
    // 3. If a pointer reaches the end of its linked list,
    // redirect it to the head of the other linked list.
    // 4. If the two linked lists intersect,
    // the pointers will eventually meet at the

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {
            // if (pointerA == null) {
            // pointerA = headB;
            // } else {
            // pointerA = pointerA.next;
            // }

            // if (pointerB == null) {
            // pointerB = headA;
            // } else {
            // pointerB = pointerB.next;
            // }

            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        return pointerA; // or pointerB, they are equal at this point
    }

    // --------------------

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();

        // Example usage
        int[] arrA = { 4, 1, 8, 4, 5 };
        int[] arrB = { 5, 6, 1, 8, 4, 5 };

        ListNode headA = solution.createLinkedList(arrA);
        ListNode headB = solution.createLinkedList(arrB);

        System.out.println("Linked List A:");
        solution.printLinkedList(headA);

        System.out.println("Linked List B:");
        solution.printLinkedList(headB);

        ListNode intersection = solution.getIntersectionNode(headA, headB);
        System.out.println("Intersection at: " + intersection);

    }

}