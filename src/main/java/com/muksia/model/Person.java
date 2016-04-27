package com.muksia.model;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.bson.Document;

/**
 *
 * @author yurzav
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Person {
    
    private String name;
    
    private String comment;
    
    private List<Word> words;

    public Person(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public List<Word> getWords() {
        return words;
    }
    
    public Document createDocument() {
        return new Document("person",
                new Document()
                        .append("name", getName())
                        .append("comment", getComment())
                        .append("words", getWordDocuments()));        
    }
    
    private List<Document> getWordDocuments(){
        return words.stream().map(p->p.createDocument()).collect(Collectors.toList());
    }
 
    
}
