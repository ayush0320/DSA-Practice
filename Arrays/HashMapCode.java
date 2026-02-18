import java.util.*;

// https://www.youtube.com/watch?v=KDZ_IXvpMG4
// HashMaps in java are used to store data in key-value pairs
// Hashing is a technique used to uniquely identify and access data
// quickly using a function called a hash function.
// It is widely used in computer science for data storage, retrieval, and security

public class HashMapCode {

    static class HashMap<K, V> { // Generic class Node with type parameters
        public class Node {
            K key;
            V value;

            // Constructor to initialize key and value
            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // number of nodes
        private int N; // size of the bucket array
        private LinkedList<Node>[] buckets; // array of linked lists

        @SuppressWarnings("unchecked")

        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
    }
}
