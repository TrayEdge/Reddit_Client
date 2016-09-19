
package app.st1ch.redditclient.data.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by st1ch on 14.09.2016.
 */
public class Data {

    private Facets facets;
    private String modhash;
    private List<Child> children = new ArrayList<Child>();
    private String after;
    private String before;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Facets getFacets() {
        return facets;
    }

    public void setFacets(Facets facets) {
        this.facets = facets;
    }

    public String getModhash() {
        return modhash;
    }

    public void setModhash(String modhash) {
        this.modhash = modhash;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Data{" +
                "facets=" + facets +
                ", modhash='" + modhash + '\'' +
                ", children=" + children +
                ", after='" + after + '\'' +
                ", before=" + before +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
