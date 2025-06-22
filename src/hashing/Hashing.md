# Hashing: Prefetching and Storing - Comprehensive Guide

## 1. What is Hashing?

**Hashing** is a fundamental technique in computer science that maps data of arbitrary size to fixed-size values. The function that performs this mapping is called a **hash function**. Hashing enables efficient data retrieval by converting search keys into array indices, allowing for near-constant time lookups, insertions, and deletions.

```
Basic Hashing Process:
                 
  Key ──→ Hash Function ──→ Index ──→ Value
 "cat"      h("cat")        [2]      "Feline"
 "dog"      h("dog")        [5]      "Canine"
 "fish"     h("fish")       [0]      "Aquatic"
```

## 2. Prefetching in Hashing

### What is Prefetching?

**Prefetching** is a performance optimization technique where the system proactively loads data into faster memory (typically CPU cache) before it's actually needed by the executing code.

### How Prefetching Works

1. The system predicts which memory locations will be accessed in the near future
2. It loads those memory locations into the CPU cache
3. When the program actually needs the data, it's already available in the cache
4. This significantly reduces memory access latency

### Benefits of Prefetching

- **Reduced Latency**: Minimizes CPU idle time waiting for data from main memory
- **Improved Throughput**: Allows processing more data in less time
- **Better Utilization**: Helps bridge the gap between CPU and memory speeds

### Prefetching in Java Context

While Java doesn't provide direct control over CPU prefetching like lower-level languages such as C++, several mechanisms still enable prefetching benefits:

- **JVM Implementation**: Modern JVMs can analyze access patterns and provide hints to the CPU
- **Hardware Prefetching**: CPUs have built-in hardware prefetchers that detect access patterns
- **JIT Compiler Optimizations**: The Just-In-Time compiler can reorganize code for better prefetching
- **Memory Layout**: Java developers can organize data structures to benefit from automatic prefetching

### Example: Implicit Prefetching in a Java Loop

```java
// The JVM may detect this sequential access pattern and prefetch array elements
for (int i = 0; i < largeArray.length; i++) {
    process(largeArray[i]);
}
```

## 3. Storing in Hashing

### The Storing Process

Storing data in a hash table involves several key steps:

1. **Compute Hash**: Apply the hash function to the key
2. **Calculate Index**: Map the hash value to a valid array index
3. **Store Entry**: Place the key-value pair at the calculated index
4. **Handle Collisions**: Address situations where multiple keys map to the same index

### Detailed Java Example with Explanation

```java
/**
 * A simple hash table entry that can form a linked list for collision handling
 */
class HashEntry {
    String key;
    int value;
    HashEntry next; // Reference to the next entry (for collision handling via chaining)

    HashEntry(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

/**
 * A simplified implementation of a hash map to demonstrate key concepts
 */
class HashMapCustom {
    private HashEntry[] table;      // The underlying array that stores entries
    private int capacity = 16;      // Initial size of the hash table
    private int size = 0;           // Number of key-value pairs stored
    private double loadFactor = 0.75; // Threshold for resizing

    public HashMapCustom() {
        table = new HashEntry[capacity];
    }

    /**
     * Calculate hash code for a key
     */
    private int hash(String key) {
        // Using Java's built-in hashCode() with additional bit manipulation
        // to reduce clustering
        int h = key.hashCode();
        return Math.abs(h ^ (h >>> 16)) % capacity;
    }

    /**
     * Store a key-value pair in the hash map
     */
    public void put(String key, int value) {
        // Check if resizing is needed
        if ((double)size / capacity >= loadFactor) {
            resize();
        }

        // Calculate the index using the hash function
        int index = hash(key);
        
        // Create new entry
        HashEntry entry = new HashEntry(key, value);

        // Case 1: Empty slot
        if (table[index] == null) {
            table[index] = entry;
            size++;
            return;
        }
        
        // Case 2: Key already exists (update value)
        HashEntry current = table[index];
        if (current.key.equals(key)) {
            current.value = value;
            return;
        }
        
        // Case 3: Collision - traverse the chain to find the end or matching key
        while (current.next != null) {
            current = current.next;
            
            // If we find the same key, update its value
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
        }
        
        // Add to end of chain
        current.next = entry;
        size++;
    }
    
    /**
     * Retrieve a value by key
     */
    public Integer get(String key) {
        int index = hash(key);
        
        // Empty slot
        if (table[index] == null) {
            return null;
        }
        
        // Check first entry and chain
        HashEntry current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        
        // Key not found
        return null;
    }
    
    /**
     * Double the capacity of the hash table and rehash all entries
     */
    private void resize() {
        int oldCapacity = capacity;
        capacity *= 2;
        HashEntry[] oldTable = table;
        table = new HashEntry[capacity];
        size = 0;
        
        // Rehash all existing entries
        for (int i = 0; i < oldCapacity; i++) {
            HashEntry current = oldTable[i];
            while (current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
    }
}
```

## 4. Array vs. Hash Map Comparison

| Feature | Array | Hash Map |
|---------|-------|----------|
| **Access Time** | O(1) - Direct index access | O(1) average, O(n) worst case |
| **Key Type** | Integer indices only | Any object that implements hashCode() and equals() |
| **Memory Usage** | Fixed size, may waste space | Dynamic, grows as needed |
| **Memory Layout** | Contiguous memory | Scattered with potential for cache misses |
| **Insertion** | O(1) if index known | O(1) average with potential rehashing |
| **Resizing** | Not automatic, requires manual copying | Automatic when load factor threshold is reached |
| **Iteration Order** | Predictable order | Usually unpredictable, depends on hash values |
| **Implementation** | Language built-in data structure | Complex data structure with collision handling |

## 5. Time Complexity in Hashing

| Operation | Average Case | Worst Case | Explanation |
|-----------|--------------|------------|-------------|
| **Insert** | O(1) | O(n) | Average case assumes good hash distribution. Worst case occurs with many collisions. |
| **Search** | O(1) | O(n) | Fast lookup with direct indexing in average case. Linear search through collision chain in worst case. |
| **Delete** | O(1) | O(n) | Similar to search, but with additional step to maintain chain integrity. |

### Factors Affecting Time Complexity

1. **Hash Function Quality**: A good hash function distributes keys uniformly
2. **Load Factor**: The ratio of entries to table size (higher values increase collision probability)
3. **Collision Resolution Strategy**: Some strategies perform better than others for specific data patterns
4. **Initial Capacity**: Starting with an appropriate size can reduce early resizing operations

## 6. Understanding Collisions

### What is a Collision?

A **collision** occurs when two different keys produce the same hash value or index in the hash table. This is inevitable due to the pigeonhole principle - when mapping a larger set of possible keys to a smaller set of indices.

```
Collision Example:
                      ┌─────────┐
  "cat" ──→ Hash Function ──→ 2 │ "Feline"
                      │         │
  "bat" ──→ Hash Function ──→ 2 │ COLLISION!
                      └─────────┘
```

### Collision Resolution Strategies

#### 1. Chaining (Open Hashing)

Store multiple entries at the same index using a linked data structure:

- **Implementation**: Each array slot contains a linked list, tree, or other collection
- **Pros**: Simple to implement, performs well with good hash function
- **Cons**: Requires additional memory for pointers, potential cache inefficiency
- **Best used when**: Hash distribution is unpredictable or load factors are high

```
Chaining Example:
                                   ┌──────────────────────────────┐
Index 0 ─────────────────────────►│ "fish"→"Aquatic"             │
                                  ├──────────────────────────────┤
Index 1 ─────────────────────────►│ "bird"→"Avian"               │
                                  ├──────────────────────────────┤
Index 2 ─────────────────────────►│ "cat"→"Feline" → "bat"→"Mammal" │
                                  ├──────────────────────────────┤
Index 3 ─────────────────────────►│ [Empty]                      │
                                  ├──────────────────────────────┤
Index 4 ─────────────────────────►│ [Empty]                      │
                                  ├──────────────────────────────┤
Index 5 ─────────────────────────►│ "dog"→"Canine"               │
                                  └──────────────────────────────┘
```

#### 2. Open Addressing (Closed Hashing)

Find another slot in the table when a collision occurs:

- **Linear Probing**: Check the next slot sequentially until an empty one is found
  ```
  index = (hash(key) + i) % capacity  // i increases by 1
  ```

- **Quadratic Probing**: Check slots at quadratically increasing distances
  ```
  index = (hash(key) + i² + i) % capacity  // i = 0, 1, 2...
  ```

- **Double Hashing**: Use a second hash function to determine the step size
  ```
  index = (hash1(key) + i * hash2(key)) % capacity
  ```

**Pros**: Better cache locality, no extra pointers  
**Cons**: More complex deletion, sensitive to clustering, requires lower load factor  
**Best used when**: Memory efficiency is crucial and load factor is controlled

```
Linear Probing Example:
                            
Key: "bat" → Hash → Index 2 → Occupied by "cat" → Check Index 3 → Empty → Store "bat" at Index 3

┌─────────────┬─────────────┬─────────────┬─────────────┬─────────────┬─────────────┐
│    [0]      │     [1]     │     [2]     │     [3]     │     [4]     │     [5]     │
│  "fish"     │   "bird"    │    "cat"    │    "bat"    │    Empty    │    "dog"    │
│ "Aquatic"   │   "Avian"   │  "Feline"   │  "Mammal"   │             │  "Canine"   │
└─────────────┴─────────────┴─────────────┴─────────────┴─────────────┴─────────────┘
```

## 7. Hashing Performance Optimization

### Load Factor Management

- **Definition**: The ratio of occupied slots to total slots in the hash table
- **Optimal Range**: Typically between 0.6 and 0.75
- **Impact**: Lower load factors reduce collisions but waste memory, higher load factors save memory but increase collision probability

### Hash Function Design Principles

A good hash function should:

1. **Distribute uniformly** across the entire range of possible table indices
2. **Be fast to compute** to minimize overhead
3. **Use all bits** of the input to maximize distribution quality
4. **Avoid clustering** by spreading similar keys apart

### Java's HashMap Implementation

Java's HashMap incorporates several advanced techniques:

- **Tree Conversion**: When a bucket exceeds a threshold of entries (8 in Java 8+), the linked list converts to a red-black tree for O(log n) worst-case lookups
- **Bit Manipulation**: Uses XOR and bit shifts for better distribution
- **Capacity Management**: Maintains capacity as a power of 2 for efficient modulo operations

```java
// Simplified example of Java's hash calculation
int hash(Object key) {
    int h = key.hashCode();
    return h ^ (h >>> 16); // XOR high bits with low bits for better distribution
}
```

## 8. Practical Applications

### 1. Database Indexing

Hash tables provide fast access to records based on key values, crucial for:
- Primary key lookups
- Join operations
- Unique constraint enforcement

### 2. Caching Systems

In-memory caches like Memcached and Redis use hashing to provide:
- Fast data retrieval
- Distributed data storage across multiple nodes
- Consistent hashing for minimal redistribution during scaling

### 3. Language Implementations

Programming languages use hash tables internally for:
- Symbol tables in compilers and interpreters
- Method dispatch in dynamic languages
- Implementation of sets, dictionaries, and other collections

### 4. Network Applications

- **Load Balancing**: Distribute requests across servers
- **Content Delivery**: Route users to nearest cache
- **Deduplication**: Identify identical data chunks

## 9. Summary

Hashing is a powerful technique that enables efficient data storage and retrieval. By understanding the principles of prefetching and storing, along with proper collision handling, you can leverage hash-based data structures to build high-performance applications.

The key takeaways:

1. **Efficient Access**: Hash tables provide O(1) average-case performance for lookups, insertions, and deletions
2. **Hardware Optimization**: Prefetching helps bridge the gap between CPU and memory speeds
3. **Collision Management**: Proper hash function design and collision resolution strategies are crucial
4. **Performance Tuning**: Load factor, initial capacity, and hash quality all impact overall system performance

With these concepts in mind, you can make informed decisions about when and how to use hash-based data structures in your applications.
