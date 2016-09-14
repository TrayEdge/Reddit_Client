
package app.st1ch.redditclient.data.entity;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by st1ch on 14.09.2016.
 */
public class Child {

    private String kind;
    private RedditPost data;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public RedditPost getData() {
        return data;
    }

    public void setData(RedditPost data) {
        this.data = data;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Child{" +
                "kind='" + kind + '\'' +
                ", data=" + data +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
