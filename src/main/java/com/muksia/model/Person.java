package com.muksia.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yurzav
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Person {
    
    private String name;
    
    private String comment;

    public Person(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public Person() {
    }
    
    
    
}
