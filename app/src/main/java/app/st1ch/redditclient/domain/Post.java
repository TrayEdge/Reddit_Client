package app.st1ch.redditclient.domain;

/**
 * Created by st1ch on 13.09.2016.
 */
public class Post {
    String id;
    String title;
    String author;
    String thumbnail;
    long date;

    public Post(String id, String title, String author, String thumbnail, long date) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.thumbnail = thumbnail;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public long getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", date=" + date +
                '}';
    }
}
