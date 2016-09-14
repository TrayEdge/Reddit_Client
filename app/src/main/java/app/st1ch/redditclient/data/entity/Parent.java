package app.st1ch.redditclient.data.entity;

/**
 * Created by st1ch on 14.09.2016.
 */
public class Parent {

    private String kind;
    private Data data;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "kind='" + kind + '\'' +
                ", data=" + data +
                '}';
    }
}
