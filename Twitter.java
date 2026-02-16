/*
Implement a simplified version of Twitter which allows users to post tweets, follow/unfollow each other, and view the 10 most recent tweets within their own news feed.

Users and tweets are uniquely identified by their IDs (integers).

Implement the following methods:

Twitter() Initializes the twitter object.
void postTweet(int userId, int tweetId) Publish a new tweet with ID tweetId by the user userId. You may assume that each tweetId is unique.
List<Integer> getNewsFeed(int userId) Fetches at most the 10 most recent tweet IDs in the user's news feed. Each item must be posted by users who the user is following or by the user themself. Tweets IDs should be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId follows the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId unfollows the user with ID followeeId.
*/
import java.util.*;
public class Twitter {
   Deque<String> tweets;
   Map<Integer,List<Integer>> followerMapping;
    public Twitter() {
        tweets=new ArrayDeque<String>();
        followerMapping=new HashMap<>(); //User //following
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.push(userId+","+tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
      List<Integer> userFeed=new ArrayList<>();
      Scanner tweetScanner;
      List<Integer> userFollowers=new ArrayList<>();
      if(followerMapping.get(userId)!=null)
      {
        userFollowers=followerMapping.get(userId);
      }

      Iterator<String> iterator=tweets.iterator();
      while (iterator.hasNext()) {
        tweetScanner=new Scanner(iterator.next());
        tweetScanner.useDelimiter(",");
        String posterID=tweetScanner.next();
        if(posterID.equals(String.valueOf(userId))||userFollowers.contains(Integer.valueOf(posterID)) )
        {
            userFeed.add(Integer.valueOf(tweetScanner.next()));
        }
        if(userFeed.size()==10)
        {
            break;
        }
      } 
      return userFeed;
    }
    
    public void follow(int followerId, int followeeId) {
       if(followerMapping.containsKey(followerId))
       {
        if(!followerMapping.get(followerId).contains(followeeId))
        {
          followerMapping.get(followerId).add(followeeId);
        }
       }
       else{
        followerMapping.put(followerId, new ArrayList<>(Arrays.asList(followeeId)));
       }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerMapping.containsKey(followerId)){
        followerMapping.get(followerId).remove((Integer)followeeId);
    }
    } 
    public void main(String[] args) {
      Twitter twitter = new Twitter();
        twitter.postTweet(7, 23); // User 1 posts a new tweet with id = 10.
        twitter.postTweet(7, 24); // User 2 posts a new tweet with id = 20.
        twitter.postTweet(7, 25); 
        twitter.postTweet(7, 26); 
        twitter.follow(8, 7);
        twitter.getNewsFeed(8);   // User 1's news feed should only contain their own tweets -> [10].
        twitter.follow(8, 7);   // User 2's news feed should only contain their own tweets -> [20].
        twitter.unfollow(8, 7);    // User 1 follows user 2.
        System.out.println(twitter.getNewsFeed(8));;   // User 1's news feed should contain both tweets from user 1 and user 2 -> [20, 10].
    }
}
