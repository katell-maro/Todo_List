package com.todolist.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.todolist.entity.User;

public class UserDao {
	private EntityManager em;
    
    private void openConnection() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Todo_List");
    	em = emf.createEntityManager();
    }
 
    public User save(User user) {
    	this.openConnection();
    	User newUser = new User();
        try {
        	em.getTransaction().begin();
            newUser = em.merge(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return newUser;
    }
    
    public User getByLogin(String login) {
    	this.openConnection();
    	try {
    		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.login=:login", User.class);
    		query.setParameter("login", login);
            return query.getSingleResult();
    	} finally {
    		em.close();
    	}
    }
}
