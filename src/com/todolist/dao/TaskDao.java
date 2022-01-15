package com.todolist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.todolist.entity.Task;

public class TaskDao {
    private EntityManager em;
    
    private void openConnection() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Todo_List");
    	em = emf.createEntityManager();
    }
    
    public List<Task> getAllByUser(Long idUser) {
    	this.openConnection();
    	try {
    		TypedQuery<Task> query = em.createQuery("SELECT t FROM Task t WHERE t.user.id=:idUser ORDER BY t.id", Task.class);
    		query.setParameter("idUser", idUser);
    	    return query.getResultList();
    	} finally {
    		em.close();
    	}
    }
 
    public void save(Task task) {
    	this.openConnection();
        try {
        	em.getTransaction().begin();
            em.merge(task);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(Long id) {
    	this.openConnection();
    	try {
    		em.getTransaction().begin();
            TypedQuery<Task> query = em.createQuery("SELECT t FROM Task t WHERE t.id = :id", Task.class);
            query.setParameter("id", id);
            Task task = query.getSingleResult();
            em.remove(task);
            em.getTransaction().commit();
    	} finally {
    		em.close();
    	}
    }
    
    public void checked(Long id) {
    	this.openConnection();
    	try {
    		em.getTransaction().begin();
            TypedQuery<Task> query = em.createQuery("SELECT t FROM Task t WHERE t.id = :id", Task.class);
            query.setParameter("id", id);
            Task task = query.getSingleResult();
            task.setChecked(!task.getChecked());
            em.merge(task);
            em.getTransaction().commit();
    	} finally {
    		em.close();
    	}
    }
}