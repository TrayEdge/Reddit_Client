package app.st1ch.redditclient.domain;

/**
 * Created by st1ch on 05.09.2016.
 */
public class Error {
    private String type;
    private String message;

    public Error(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
