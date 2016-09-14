package app.st1ch.redditclient.domain;

/**
 * Created by st1ch on 05.09.2016.
 */
public interface ErrorHandler {
    String handleError(Throwable t);
}
