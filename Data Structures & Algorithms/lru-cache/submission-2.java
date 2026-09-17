class LRUCache {

    // MRU <-> Node <-> Node <-> Node <-> LRU
    Node mostRecent;
    Node leastRecent;
    Map<Integer, Node> cache;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.mostRecent = new Node(0, 0);
        this.leastRecent = new Node(0, 0);
        mostRecent.next = leastRecent;
        leastRecent.prev = mostRecent;
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
    }
    
    public int get(int key) {
        // check if key exists in cache
        if (!cache.containsKey(key)) {
            // if not, return -1
            return -1;
        }

        // if so, get node, move to most recent
        Node current = cache.get(key);
        // excise
        current.prev.next = current.next;
        current.next.prev = current.prev;
        // insert
        Node temp = mostRecent.next;
        mostRecent.next = current;
        current.prev = mostRecent;
        temp.prev = current;
        current.next = temp;


        return current.val;
    }
    
    public void put(int key, int value) {
        // check if key exists in cache
        if (cache.containsKey(key)) {
            // if so, update value, move to most recent
            Node current = cache.get(key);
            current.val = value;
            // excise
            current.prev.next = current.next;
            current.next.prev = current.prev;
            // insert
            Node temp = mostRecent.next;
            mostRecent.next = current;
            current.prev = mostRecent;
            temp.prev = current;
            current.next = temp;

        } else {
        // if not, check if cache is full
            if (size == capacity) {
            // if so, evict least recent from list and cache
                // excise
                Node evict = leastRecent.prev;
                evict.prev.next = leastRecent;
                leastRecent.prev = evict.prev;
                // remove from cache
                cache.remove(evict.key);
                size--;
            }
            // put node in most recent in list and in cache
            Node insert = new Node(key, value);
            Node temp = mostRecent.next;
            mostRecent.next = insert;
            insert.prev = mostRecent;
            temp.prev = insert;
            insert.next = temp;
            cache.put(key, insert);
            size++;
        }        
    }
}
    // MRU <-> Node <-> Node <-> Node <-> LRU


class Node {
    public int key;
    public int val;
    public Node next;
    public Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
