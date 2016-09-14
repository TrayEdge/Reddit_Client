package app.st1ch.redditclient.data.mappers;

/**
 * Created by st1ch on 14.09.2016.
 */
public interface Mapper<A, B> {
    B transform(A obj) throws RuntimeException;
}
