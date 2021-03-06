package de.foryasee.httprequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple HTTP Request
 *
 * @author Yannick Seeger / ForYaSee
 */
public class RequestHeader {

    private List<RequestHeaderField> fields;

    public RequestHeader() {
        fields = new ArrayList<>();
    }

    /**
     * 
     * @param key
     * @param value
     */
    public void addField(String key, String value) {
        if (key != null || value != null) {
            fields.add(new RequestHeaderField(key, value));
        } else {
            throw new NullPointerException("Key or value can not be null.");
        }
    }

    public void addField(RequestHeaderField field) {
        if (field != null) {
            fields.add(field);
        } else {
            throw new NullPointerException("Key or value can not be null.");
        }
    }

    public List<RequestHeaderField> getRequestFields() {
        return fields;
    }
}
