// LC 2. Add Two Numbers
// https://youtu.be/XmRrGzR6udg

// Pattern: Linked List + Dummy Node
// 1. Add corresponding nodes of the two linked lists along with any carry from the previous addition.
// 2. Create a new node for the sum of the two nodes and the carry, and append it to the result linked list.
// 3. If the sum exceeds 9, carry over the excess to the next addition.
// 4. Continue this process until both linked lists are fully traversed and there is no carry left.

// ------------------------------------------------------------------------

public class AddTwoNumbers {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            // Create a new node with the last digit of the sum and update carry
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;

            // Move the current pointer to the next node
            curr = curr.next;
        }

        // Return the next node of dummy, which is the head of the resulting linked list
        return dummy.next;
    }

    // --------------------

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();

        // Test case 1
        ListNode l1 = solution.createLinkedList(new int[] { 2, 4, 3 });
        ListNode l2 = solution.createLinkedList(new int[] { 5, 6, 4 });
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.print("Test Case 1: ");
        solution.printLinkedList(result); // Expected Output: 7 -> 0 -> 8 -> null

        // Test case 2
        l1 = solution.createLinkedList(new int[] { 0 });
        l2 = solution.createLinkedList(new int[] { 0 });
        result = solution.addTwoNumbers(l1, l2);
        System.out.print("Test Case 2: ");
        solution.printLinkedList(result); // Expected Output: 0 -> null

        // Test case 3
        l1 = solution.createLinkedList(new int[] { 9, 9, 9, 9, 9, 9, 9 });
        l2 = solution.createLinkedList(new int[] { 9, 9, 9, 9 });
        result = solution.addTwoNumbers(l1, l2);
        System.out.print("Test Case 3: ");
        solution.printLinkedList(result); // Expected Output: 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1 -> null
    }
}
