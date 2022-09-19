import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.io.File;

public class TwitterAPI {

    private static Twitter getTwitterinstance() {
        Twitter twitter = TwitterFactory.getSingleton();
        return twitter;
    }

    private static String createTweet(String tweet) throws TwitterException {
        Twitter twitter = getTwitterinstance();
        Status status = twitter.updateStatus(tweet);
        return status.getText();
    }

    public static void tweetContents(String message) throws TwitterException{
        createTweet(message);

    }


}