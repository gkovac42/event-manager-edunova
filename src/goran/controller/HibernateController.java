/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.controller;

import goran.model.Entity;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Goran
 * @param <T>
 */
public class HibernateController<T extends Entity> {
    
    private final Session session;

    public HibernateController() {
        
        session = HibernateUtil.getSession();
    }

    public T save(T entity) {
        
        Date currentDate = new Date();
        if (entity.getId() == null) {
            entity.setDateCreated(currentDate);
        }
        entity.setDateModified(currentDate);
        
        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
        
        return entity;
    }

    public void delete(T entity) {
        
        entity.setDeleted(true);
        save(entity);
    }
    
    public void permDelete (T entity) {
        
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
}

    public List<T> saveList(List<T> list) {
        
        Date currentDate = new Date();
        session.beginTransaction();
        
        list.stream().forEach((entity) -> {
            if (entity.getId() == null) {
                entity.setDateCreated(currentDate);
            }
            entity.setDateModified(currentDate);
            session.saveOrUpdate(entity);
        });
        session.getTransaction().commit();
        
        return list;
    }
    
    public List<T> getList(T entity) {
        
        List<T> list = HibernateUtil.getSession().createQuery
        ("from " + entity.getClass().getName() + " where deleted=false").list();
        
        return list;
    }
    
    public List<T> getOrderedList(T entity, String s) {
        
        List<T> list = HibernateUtil.getSession().createQuery
        ("from " + entity.getClass().getName() + " where deleted=false order by " + s).list();
        
        return list;
    }
    
    public List<T> find(T entity, String param, String find) {
        
        List<T> list = HibernateUtil.getSession().createQuery
        ("from " + entity.getClass().getName() + " where deleted=false and " + param + " like ?")
                .setString(0, "%"+ find +"%").list();
        
        return list;
    }
}
