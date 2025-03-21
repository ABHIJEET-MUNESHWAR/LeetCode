class Solution {
    private Set<String> visited = new HashSet<>();

    public int openLock(String[] deadEnds, String target) {
        if (target == null || deadEnds.length == 0) {
            return -1;
        }
        int level = 0;
        for (String deadEnd : deadEnds) {
            visited.add(deadEnd);
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String currentLock = queue.poll();
                if (currentLock.equals(target)) {
                    return level;
                }
                if (visited.contains(currentLock)) {
                    continue;
                }
                for (String nextLock : getNextLocks(currentLock)) {
                    if (!visited.contains(nextLock)) {
                        queue.add(nextLock);
                    }
                }
                visited.add(currentLock);
            }
            level++;
        }
        return -1;
    }

    private Set<String> getNextLocks(String currentLock) {
        Set<String> newLocks = new HashSet<>();
        char[] lockChars = currentLock.toCharArray();
        for (int i = 0; i < lockChars.length; i++) {
            char lock = lockChars[i];
            lockChars[i] = lock == '9' ? '0' : (char) (lock + 1);
            newLocks.add(new String(lockChars));
            lockChars[i] = lock == '0' ? '9' : (char) (lock - 1);
            newLocks.add(new String(lockChars));
            lockChars[i] = lock;
        }
        return newLocks;
    }
}