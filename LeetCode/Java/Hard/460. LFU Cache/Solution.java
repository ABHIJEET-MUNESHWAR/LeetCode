
class LFUCache {

    private final int capacity;

    // Tracks the minimum frequency currently present in the cache.
    private int minFrequency = 0;

    // key -> value
    private final Map<Integer, Integer> keyToValue = new HashMap<>();

    // key -> frequency
    private final Map<Integer, Integer> keyToFrequency = new HashMap<>();

    // frequency -> keys having that frequency
    //
    // LinkedHashSet maintains insertion order.
    // Therefore, the first key in the set is the LRU key
    // among all keys having the same frequency.
    private final Map<Integer, LinkedHashSet<Integer>> frequencyToKeys = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        // Key does not exist.
        if (!keyToValue.containsKey(key)) {
            return -1;
        }

        // Get current frequency.
        int currentFrequency = keyToFrequency.get(key);

        // Remove key from its current frequency bucket.
        removeKeyFromFrequency(key, currentFrequency);

        // If this was the last key with the minimum frequency,
        // increase the minimum frequency.
        if (currentFrequency == minFrequency
                && frequencyToKeys.get(currentFrequency).isEmpty()) {

            frequencyToKeys.remove(currentFrequency);
            minFrequency++;
        }

        // Move key to the next frequency bucket.
        addKeyToFrequency(key, currentFrequency + 1);

        return keyToValue.get(key);
    }

    public void put(int key, int value) {

        // Nothing can be stored when capacity is zero.
        if (capacity == 0) {
            return;
        }

        // Key already exists.
        if (keyToValue.containsKey(key)) {

            // Update value.
            keyToValue.put(key, value);

            // Updating an existing key counts as a usage.
            increaseFrequency(key);

            return;
        }

        // Cache is full. Remove the LFU + LRU key.
        if (keyToValue.size() == capacity) {
            evictLeastFrequentlyUsedKey();
        }

        // New keys always start with frequency 1.
        minFrequency = 1;

        keyToValue.put(key, value);
        keyToFrequency.put(key, 1);

        addKeyToFrequency(key, 1);
    }

    /**
     * Increases the frequency of an existing key by one.
     */
    private void increaseFrequency(int key) {

        int currentFrequency = keyToFrequency.get(key);

        // Remove from old frequency bucket.
        removeKeyFromFrequency(key, currentFrequency);

        // Add to new frequency bucket.
        addKeyToFrequency(key, currentFrequency + 1);

        // If the old frequency was the minimum frequency
        // and became empty, update minFrequency.
        if (currentFrequency == minFrequency
                && frequencyToKeys.get(currentFrequency).isEmpty()) {

            frequencyToKeys.remove(currentFrequency);
            minFrequency++;
        }
    }

    /**
     * Adds a key to the bucket corresponding to its frequency.
     */
    private void addKeyToFrequency(int key, int frequency) {

        keyToFrequency.put(key, frequency);

        frequencyToKeys
                .computeIfAbsent(frequency, f -> new LinkedHashSet<>())
                .add(key);
    }

    /**
     * Removes a key from its frequency bucket.
     */
    private void removeKeyFromFrequency(int key, int frequency) {

        LinkedHashSet<Integer> keys = frequencyToKeys.get(frequency);

        if (keys != null) {
            keys.remove(key);
        }
    }

    /**
     * Removes the least frequently used key.
     *
     * If multiple keys have the same minimum frequency,
     * the least recently used key is removed.
     */
    private void evictLeastFrequentlyUsedKey() {

        LinkedHashSet<Integer> keys = frequencyToKeys.get(minFrequency);

        // First element = oldest key in this frequency bucket.
        int keyToEvict = keys.iterator().next();

        keys.remove(keyToEvict);

        keyToValue.remove(keyToEvict);
        keyToFrequency.remove(keyToEvict);

        if (keys.isEmpty()) {
            frequencyToKeys.remove(minFrequency);
        }
    }
}
