package com.todolist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="user", schema="todolist")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @NotNull
    @Column(unique=true)
    private String login;
    
    public User() {}
    
    public User(Long id) {
    	this.id = id;
    }
    
    
    public Long getId() {
    	return this.id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public String getLogin() {
    	return this.login;
    }
    
    public void setLogin(String login) {
    	this.login = login;
    }
    
    public String toString() {
    	return "{ id: " + id +
    			", login: " + login + " }";
    }
}
