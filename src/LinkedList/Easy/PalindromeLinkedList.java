package linkedlist.easy;
package linkedlist.Easy;
// LC 234. Palindrome Linked List
// https://youtu.be/lNCwD7QswjI

// Pattern: Tortoise and Hare (Fast & Slow Pointer) Pattern
// 1. Two pointers: slow and fast
// 2. Reverse linked list
// 3. Two pointer comparison

public class PalindromeLinkedList {

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

    // Reverse the linked list
    // public ListNode reverseList(ListNode head) {
    // if (head == null || head.next == null) {
    // return head; // base case: empty list or single node is already reversed
    // }

    // ListNode prev = null; // previous node
    // ListNode curr = head; // current node
    // while (curr != null) {
    // ListNode next = curr.next;
    // curr.next = prev;
    // prev = curr;
    // curr = next;
    // }
    // return prev; // new head of the reversed list
    // }

    // --------------------

    // Check if the linked list is a palindrome
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // A single node or empty list is a palindrome
        }

        // 1. Find the middle of the linked list using fast and slow pointers
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // move slow by 1 step
            fast = fast.next.next; // move fast by 2 steps
        }

        // 2. Reverse the second half of the linked list
        ListNode prev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // 3. Compare both halves
        while (prev != null) {
            // If values are not equal, it's not a palindrome
            if (head.data != prev.data) {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true; // All values matched, it's a palindrome
    }

    // --------------------

    public static void main(String[] args) {
        PalindromeLinkedList solution = new PalindromeLinkedList();

        int[] arr = { 1, 2, 3, 2, 1 };

        ListNode head = solution.createLinkedList(arr);

        System.out.println("Original List:");
        solution.printLinkedList(head); // Print the original linked list

        // Check if the linked list is a palindrome
        System.out.println("Is Palindrome? " + solution.isPalindrome(head));
    }

}
