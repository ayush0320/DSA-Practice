// https://youtu.be/e0s-zmpedYo

public class TraverseLinkedList {

    // Node class
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Head of list
    private ListNode head;

    // --------------------

    // Insert at end
    public void insert(int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) {
            head = newNode;
            return;
        }

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // --------------------

    // Traverse the linked list and print values
    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // --------------------

    public static void main(String[] args) {
        TraverseLinkedList list = new TraverseLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.println("Linked List:");
        list.display();

    }
}
