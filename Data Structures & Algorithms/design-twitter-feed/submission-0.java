class Twitter {
    List<Tweet> tweets;
    Map<Integer, Set<Integer>> users;

    public Twitter() {
        tweets = new ArrayList<>();
        users = new HashMap<>();        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(userId, tweetId));       
        if (!users.containsKey(userId)) {
            users.put(userId, new HashSet<Integer>());
            users.get(userId).add(userId);
        } 
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        for (int i = tweets.size() - 1; i >= 0; i--) {
            if (users.get(userId).contains(tweets.get(i).userId)) {
                feed.add(tweets.get(i).tweetId);
            }

            if (feed.size() == 10) {
                break;
            }
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new HashSet<Integer>());
            users.get(followerId).add(followerId);
        }
        users.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new HashSet<Integer>());
            users.get(followerId).add(followerId);
        }
        users.get(followerId).remove(followeeId);
    }
}

class Tweet {
    public int userId;
    public int tweetId;

    public Tweet(int userId, int tweetId) {
        this.userId = userId;
        this.tweetId = tweetId;
    }
}
