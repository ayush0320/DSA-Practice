package linkedlist.easy;
package linkedlist.Easy;
// LC 21. Merge Two Sorted Lists
// https://youtu.be/jXu-H7XuClE

// Pattern:
// • Merging logic
// • Dummy Node: A temporary node used to simplify edge cases in linked list operations,
//   such as merging two lists or adding nodes to an empty list. 
//   It acts as a placeholder before the actual head of the merged list, 
//   allowing for easier manipulation of pointers without needing to check for null values.
// • It’s just a placeholder
// • It does NOT belong to final answer

// ------------------------------------------------------------------------

public class MergeTwoSortedLists {
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

    // Merge two sorted linked lists and return it as a new sorted list
    // dummy → null
    // curr = dummy

    public ListNode mergeLinkedLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1); // fake node
        ListNode curr = dummy; // pointer to build the merged list

        // Compare and merge nodes from both lists until one list is exhausted
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                curr.next = l1; // attach l1 node to merged list
                l1 = l1.next; // move l1 pointer forward
            } else {
                curr.next = l2;
                l2 = l2.next; // move l2 pointer forward
            }
            curr = curr.next; // move curr pointer forward
        }

        // attach the remaining nodes
        if (l1 != null)
            curr.next = l1;
        if (l2 != null)
            curr.next = l2;

        return dummy.next; // return the head of the merged list (skip dummy)
    }

    // --------------------

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        int[] arr1 = { 1, 3, 5 };
        int[] arr2 = { 2, 4, 6 };

        ListNode l1 = solution.createLinkedList(arr1);
        ListNode l2 = solution.createLinkedList(arr2);
        ListNode merged = solution.mergeLinkedLists(l1, l2);
        solution.printLinkedList(merged);
    }

}
