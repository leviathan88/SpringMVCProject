package com.pooldead.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//you will see that we have annotated this class with JPA annotations 
//such as @Entity and @Id. This allows instances of the Option class 
//to be easily persisted and retrieved using JPA technology.
@Entity
public class Option {
	
	@Id
    @GeneratedValue
    @Column(name="OPTION_ID")
    private Long id;

    @Column(name="OPTION_VALUE")
    private String value;
    
    //getters
    public Long getId() {
    	return id;
    }
    public String getValue() {
    	return value;
    }
    
    //setters
    public void setId(Long _id) {
    	id = _id;
    }    
    public void setValue(String _value) {
    	value = _value;    			
    }

}
