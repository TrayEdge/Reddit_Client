
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
    private Object before;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The facets
     */
    public Facets getFacets() {
        return facets;
    }

    /**
     * 
     * @param facets
     *     The facets
     */
    public void setFacets(Facets facets) {
        this.facets = facets;
    }

    /**
     * 
     * @return
     *     The modhash
     */
    public String getModhash() {
        return modhash;
    }

    /**
     * 
     * @param modhash
     *     The modhash
     */
    public void setModhash(String modhash) {
        this.modhash = modhash;
    }

    /**
     * 
     * @return
     *     The children
     */
    public List<Child> getChildren() {
        return children;
    }

    /**
     * 
     * @param children
     *     The children
     */
    public void setChildren(List<Child> children) {
        this.children = children;
    }

    /**
     * 
     * @return
     *     The after
     */
    public String getAfter() {
        return after;
    }

    /**
     * 
     * @param after
     *     The after
     */
    public void setAfter(String after) {
        this.after = after;
    }

    /**
     * 
     * @return
     *     The before
     */
    public Object getBefore() {
        return before;
    }

    /**
     * 
     * @param before
     *     The before
     */
    public void setBefore(Object before) {
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
