class Twitter {

    private static int timestamp = 0;
    private Map<Integer, User> userMap;

    private class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
            this.next = null;
        }
    }

    public class User {
        private int id;
        private Set<Integer> followed;
        public Tweet tweetHead;

        public User(int id) {
            this.id = id;
            this.followed = new HashSet<>();
            follow(id);
            this.tweetHead = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }

    public Twitter() {
        userMap = new HashMap<Integer, User>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<Integer>();
        if (!userMap.containsKey(userId)) {
            return newsFeed;
        }
        Set<Integer> followers = userMap.get(userId).followed;
        PriorityQueue<Tweet> priorityQueue = new PriorityQueue<>(followers.size(), (a, b) -> (b.time - a.time));
        for (Integer follower : followers) {
            Tweet tweet = userMap.get(follower).tweetHead;
            if (tweet != null) {
                priorityQueue.add(tweet);
            }
        }
        int i = 0;
        while (!priorityQueue.isEmpty() && i < 10) {
            Tweet tweet = priorityQueue.poll();
            newsFeed.add(tweet.id);
            i++;
            if (tweet.next != null) {
                priorityQueue.add(tweet.next);
            }
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }
        if (!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */