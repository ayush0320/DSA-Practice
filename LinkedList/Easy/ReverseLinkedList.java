// LC 206: Reverse Linked List
// • No extra space allowed (O(1) space)
// • Time complexity: O(n) where n is the number of nodes in the linked list

// Tutorial:
// Linked List: https://youtu.be/oAja8-Ulz6o
// Reverse: https://youtu.be/t7YaoQOFXzk

// Array: index based access
// Linked List: pointer based navigation

// Pattern:
// Reversing pointers (links) one by one
// • You don’t change values
// • You change connections between nodes

// • CURR pointer: current node being processed
// • PREV pointer: previous node (initially null)
// • NEXT pointer: next node (initially null)

// ------------------------------------------------------------------------

// Node class representing each node in the linked list
// int data: stores the value of the node
class ListNode {
    int data; // data stored in the node
    ListNode next; // pointer to the next node

    // Constructor to create a new node
    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// ------------------------------------------------------------------------

class ReverseLinkedList {

    // Reverse the linked list - iterative approach
    // Time complexity: O(n) where n is the number of nodes in the linked list
    // Space complexity: O(1) since we are using only a constant amount
    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null; // previous node (initially null)
        ListNode curr = head; // current node (initially head of the list)

        while (curr != null) {
            ListNode next = curr.next; // store the next node (initially null)
            curr.next = prev; // reverse the current node's pointer to point to the previous node
            prev = curr; // move the previous pointer to the current node
            curr = next; // move the current pointer to the next node (stored in next)
        }

        return prev; // prev will be the new head of the reversed list
    }

    // Helper function: create a linked list from an array
    public ListNode createLinkedList(int[] arr) {
        if (arr.length == 0)
            return null; // edge case: empty array

        ListNode head = new ListNode(arr[0]); // create head node
        ListNode curr = head; // pointer to track current node

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]); // create next node
            curr = curr.next; // move to the next node
        }

        return head;
    }

    // Print the linked list
    public void printLinkedList(ListNode head) {
        ListNode curr = head; // pointer to track current node

        while (curr != null) {
            System.out.print(curr.data + " -> "); // print current node's data
            curr = curr.next; // move to the next node
        }
        System.out.println("null"); // end of the list
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        int[] arr = { 1, 2, 3, 4, 5 };

        // Create the linked list from the array
        ListNode head = solution.createLinkedList(arr);

        System.out.println("Original List:");
        solution.printLinkedList(head); // Print the original linked list

        // Reverse the linked list
        System.out.println("Reversed List: ");
        head = solution.reverseLinkedList(head);
        solution.printLinkedList(head);

    }

}
