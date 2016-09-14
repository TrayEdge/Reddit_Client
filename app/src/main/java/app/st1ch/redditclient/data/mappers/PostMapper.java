package app.st1ch.redditclient.data.mappers;

import app.st1ch.redditclient.data.entity.RedditPost;
import app.st1ch.redditclient.domain.Post;

/**
 * Created by st1ch on 14.09.2016.
 */
public class PostMapper implements Mapper<RedditPost, Post> {
    @Override
    public Post transform(RedditPost obj) throws RuntimeException {
        return new Post(
                obj.getId(),
                obj.getTitle(),
                obj.getAuthor(),
                obj.getThumbnail(),
                Double.valueOf(obj.getCreated()).longValue()
        );
    }
}
