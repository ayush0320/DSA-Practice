//https://youtu.be/Qf-TDPr0nYw

// A heap is a specialized, tree-based data structure that is a complete binary tree, 
// satisfying the "heap property" where a parent node is either greater than or equal to (max-heap)
// or less than or equal to (min-heap) its child nodes

// Internally -> Array
// Represented as -> Tree

// Properties:
// 1. Complete Binary Tree - All levels are completely filled except possibly the last level.
// last level fills from LEFT to RIGHT
// 2. Max Heap - Every parent >= children
// 3. Min Heap - Every parent <= children

// How is the array represented in tree:
// 1. root = i
// 2. parent = i/2
// 3. left(i) = 2xi
// 4. right(i) = 2xi + 1
// 5. No pointers required

// Height: logn

// ---------------------------------------------------------------------------

package heap;

import java.util.ArrayList;

public class Heaps {

    ArrayList<Integer> heap = new ArrayList<>();

    // Insert elements into heap
    public void insert(int n) {

        // Add elements at the end
        heap.add(n);

        // Heapify up
        int index = heap.size() - 1; // last index

        while (index > 0) { // 0 is root index
            int parent = (index - 1) / 2;

            // If parent is smaller -> swap
            if (heap.get(parent) < heap.get(index)) {
                int temp = heap.get(parent);
                heap.set(parent, heap.get(index));
                heap.set(index, temp);

                index = parent;
            } else {
                break;
            }
        }
    }

    // --------------------------------------

    // Delete an element from the heap
    // 1. Replace root with last element
    // 2. Remove last element
    // 3. Heapify Down

    public

    // --------------------------------------

    public void printHeap() {
        System.out.println(heap);
    }

    // --------------------------------------

    public static void main(String[] args) {
        Heaps h = new Heaps();

        h.insert(10);
        h.insert(40);
        h.insert(20);
        h.insert(50);
        h.insert(5);

        // System.out.println(h);
        h.printHeap();

    }
}
