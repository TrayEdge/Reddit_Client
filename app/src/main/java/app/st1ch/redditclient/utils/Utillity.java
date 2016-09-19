package app.st1ch.redditclient.utils;

import java.text.SimpleDateFormat;

/**
 * Created by st1ch on 17.09.2016.
 */
public class Utillity {

    public static String convertDate(long dateInMillis){
        return new SimpleDateFormat("MMM dd").format(dateInMillis);
    }

}
