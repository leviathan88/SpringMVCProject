package com.pooldead.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vote {
	
	@Id
    @GeneratedValue
    @Column(name="VOTE_ID")
    private Long id;

	//The @ManyToOne annotation indicates that an Option instance can have zero or more Vote instances associated with it.
    @ManyToOne
    @JoinColumn(name="OPTION_ID")
    private Option option;
    
    //getters
    public Long getId() {
    	return id;
    }
    public Option getOption() {
    	return option;
    }
    
    //setters
    public void setId(Long _id) {
    	id = _id;
    }
    public void setOption(Option _option) {
    	option = _option;
    }

}
