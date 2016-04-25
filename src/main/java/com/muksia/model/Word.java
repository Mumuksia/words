package com.muksia.model;

import java.util.Date;

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
    
}
