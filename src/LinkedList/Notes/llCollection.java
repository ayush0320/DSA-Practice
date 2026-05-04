import java.util.LinkedList;

// Demonstration of LinkedList collection in Java
// https://www.youtube.com/watch?v=oAja8-Ulz6o

public class llCollection {

    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();

        // Adding elements to the LinkedList
        ll.add("Apple");
        ll.add("Banana");
        ll.add("Cherry"); // Adding element at the end by default
        System.out.println("LinkedList: " + ll);

        ll.addLast("Berry"); // Adding element at the end
        ll.addFirst("Mango"); // Adding element at the beginning
        System.out.println("LinkedList: " + ll);

        System.out.println("Size: " + ll.size()); // Returns the size of the LinkedList

        // Iteration over the LinkedList
        for (int i = 0; i < ll.size(); i++) {
            System.out.print(ll.get(i) + " -> ");
        }
        System.out.print("null");

        // Delete first element
        ll.remove(); // Removes the first element by default
        // ll.removeFirst();
        System.out.println("\nLinkedList after removing first element: " + ll);
        ll.remove(2); // Removes element at index 2
        System.out.println("LinkedList after removing element at index 2: " + ll);
    }
}
