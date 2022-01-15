package com.todolist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="task", schema="todolist")
public class Task {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @NotNull
    private String name;
    
    @NotNull
    private boolean checked;
    
    @ManyToOne
    private User user;
    
    public Task() {}
    
    public Task(String name, boolean checked, Long userId) {
    	this.name = name;
    	this.checked = checked;
    	user = new User(userId);
    }
    
    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public Boolean getChecked() {
    	return checked;
    }
    
    public void setChecked(Boolean checked) {
    	this.checked = checked;
    }
    
    public User getUser() {
    	return this.user;
    }
    
    public void setUser(User user) {
    	this.user = user;
    }
    
    public String toString() {
    	return "{ id: " + id +
    			", name: " + name +
    			", checked: " + checked + 
    			", user: " + user.toString() + " }";
    }
}
