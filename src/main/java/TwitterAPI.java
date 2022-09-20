import twitter4j.*;

import java.io.File;

public class TwitterAPI {

    private static Twitter getTwitterinstance() {
        Twitter twitter = TwitterFactory.getSingleton();
        return twitter;
    }

    private static void createTweet(String tweet, File front, File frontShiny) throws TwitterException {
        Twitter twitter = getTwitterinstance();

        // Uploading the Media for the tweet
        UploadedMedia mediaFront = twitter.uploadMedia(front);
        UploadedMedia mediaFrontShiny = twitter.uploadMedia(frontShiny);

        // Getting the media Ids and long to upload to the status
        long[] mediaIds = new long[2];
        mediaIds[0] = mediaFront.getMediaId();
        mediaIds[1] = mediaFrontShiny.getMediaId();


        // Creating a new tweet with the message and mediaIds
        StatusUpdate statusUpdate = new StatusUpdate(tweet);
        statusUpdate.setMediaIds(mediaIds);
        Status status = twitter.updateStatus(statusUpdate);

        //return status.getText();
    }

    public static void tweetContents(String message, File front, File back) throws TwitterException{

        createTweet(message, front, back);

    }

}