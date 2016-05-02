package com.muksia.model;

import java.util.Date;
import org.bson.Document;

/**
 *
 * @author yurzav
 */
public class Word {
    
    private String value;
    
    private String translation;
    
    private Date updated;

    public Word(String value, String translation, Date updated) {
        this.value = value;
        this.translation = translation;
        this.updated = updated;
    }
    
        public Document createDocument() {
        return new Document("word",
                new Document()
                        .append("value", value)
                        .append("translation", translation)
                        .append("updated", updated));        
    }

    public String getValue() {
        return value;
    }

    public String getTranslation() {
        return translation;
    }
        
        
    
}
