// LC 24. Swap Nodes in Pairs

// ------------------------------------------------------------------------

public class SwapNodesInPairs {
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

    // prev → node before the pair
    // first → first node of pair
    // second → second node of pair

    // Time complexity: O(n) where n is the length of the linked list
    // (number of iterations) × (work per iteration)
    // = (n/2) × O(1)
    // = O(n)
    // Space complexity: O(1)

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        // Iterate through the list in pairs and swap nodes
        while (prev.next != null && prev.next.next != null) { // Check if there are at least two nodes to swap
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // swap
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // move prev to the end of the swapped pair
            prev = first;
        }

        return dummy.next; // Return the new head of the list
    }

    // --------------------

    public static void main(String[] args) {
        SwapNodesInPairs solution = new SwapNodesInPairs();

        int[] arr = { 1, 2, 3, 4 };

        ListNode head = solution.createLinkedList(arr);

        System.out.println("Original list: ");
        solution.printLinkedList(head);

        // ListNode swappedHead = solution.swapPairs(head);
        System.out.println("List after swapping pairs: ");
        solution.printLinkedList(solution.swapPairs(head));

    }
}
