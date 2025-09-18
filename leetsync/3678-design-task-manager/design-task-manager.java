//Approach (Using proper Data Structures)
// T.C. : add -> O(log n), edit -> O(log n), rmv -> O(1), execTop -> O(n log n) worst case
// S.C. : O(n)
class TaskManager {
    private static class Task {
        int priority;
        int taskId;

        Task(int priority, int taskId) {
            this.priority = priority;
            this.taskId = taskId;
        }
    }

    // Max-heap: higher priority first, break ties by higher taskId
    private PriorityQueue<Task> maxHeap;
    private Map<Integer, Integer> taskPriorityMap; // taskId -> current priority
    private Map<Integer, Integer> taskOwnerMap;    // taskId -> userId

    public TaskManager(List<List<Integer>> tasks) {
        maxHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a.priority != b.priority) {
                    return b.priority - a.priority; // higher priority first
                }
                return b.taskId - a.taskId;         // break tie by higher taskId
            }
        );
        taskPriorityMap = new HashMap<>();
        taskOwnerMap = new HashMap<>();

        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    // Add a new task
    public void add(int userId, int taskId, int priority) {
        maxHeap.offer(new Task(priority, taskId));
        taskPriorityMap.put(taskId, priority);
        taskOwnerMap.put(taskId, userId);
    }

    // Edit an existing task's priority
    public void edit(int taskId, int newPriority) {
        maxHeap.offer(new Task(newPriority, taskId));
        taskPriorityMap.put(taskId, newPriority);
    }

    // Remove a task
    public void rmv(int taskId) {
        taskPriorityMap.put(taskId, -1); // mark as invalid
    }

    // Execute the top task and return its userId
    public int execTop() {
        while (!maxHeap.isEmpty()) {
            Task top = maxHeap.poll();
            int currPriority = taskPriorityMap.getOrDefault(top.taskId, -1);

            if (top.priority == currPriority) {
                taskPriorityMap.put(top.taskId, -1); // mark executed
                return taskOwnerMap.get(top.taskId);
            }
        }
        return -1; // no valid tasks
    }
}