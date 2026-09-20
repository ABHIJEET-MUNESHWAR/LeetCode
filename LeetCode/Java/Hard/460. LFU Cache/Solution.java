class LFUCache {
    int minFreq = 0;
    int capacity = 0;
    Map<Integer, Integer> keyToValueMap = new HashMap<>();
    Map<Integer, Integer> keyToFreqMap = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> freqToLRUKeys = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyToValueMap.containsKey(key)) {
            return -1;
        }
        int freq = keyToFreqMap.get(key);
        freqToLRUKeys.get(freq).remove(key);
        if (freq == minFreq && freqToLRUKeys.get(freq).isEmpty()) {
            freqToLRUKeys.remove(freq);
            minFreq++;
        }
        putFreq(key, freq + 1);
        return keyToValueMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyToValueMap.containsKey(key)) {
            keyToValueMap.put(key, value);
            get(key);
            return;
        }
        if (keyToValueMap.size() == capacity) {
            int keyToEvict = freqToLRUKeys.get(minFreq).iterator().next();
            freqToLRUKeys.get(minFreq).remove(keyToEvict);
            keyToValueMap.remove(keyToEvict);
        }
        minFreq = 1;
        keyToValueMap.put(key, value);
        putFreq(key, minFreq);
    }

    public void putFreq(int key, int freq) {
        keyToFreqMap.put(key, freq);
        freqToLRUKeys.putIfAbsent(freq, new LinkedHashSet<>());
        freqToLRUKeys.get(freq).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */