
package app.st1ch.redditclient.data.entity;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by st1ch on 14.09.2016.
 */
public class SecureMediaEmbed {

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
