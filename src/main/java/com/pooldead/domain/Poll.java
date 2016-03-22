package com.pooldead.domain;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy ;

@Entity
public class Poll {	
	@Id
    @GeneratedValue
    @Column(name="POLL_ID")
    private Long id;

    @Column(name="QUESTION")
    private String question;

    //The @OneToMany annotation, as the name suggests, indicates that a Poll instance can contain zero or more Option instances
    //The CascadeType.All indicates that any database operations such as persist, remove, or merge on a Poll instance needs to be propagated to all related Option instances. For example, when a Poll instance gets deleted, all of the related Option instances will be deleted from the database.
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="POLL_ID")
    @OrderBy
    private Set<Option> options;
    
    //getters
    public Long getId() {
    	return id;    	
    }
    public Set<Option> getOption() {
    	return options;
    }
    
    //setters
    public void setId(Long _id) {
    	id = _id;
    }
    public void setOption(Set<Option> _option) {
    	options = _option;
    }

}
