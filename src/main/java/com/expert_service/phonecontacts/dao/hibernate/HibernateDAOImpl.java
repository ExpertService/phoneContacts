package com.expert_service.phonecontacts.dao.hibernate;

import com.expert_service.phonecontacts.dao.common.Dao;
//import com.expert_service.phonecontacts.utils.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Абстрактный класс - реализация интерфейса Dao. Все операции реализованы через фабрику Hibernate
 * {@link org.springframework.orm.hibernate5.LocalSessionFactoryBean реализованную в Spring}
 * @version 1.0.0
 * @author Донченко Руслан
 */
@Component
public abstract class HibernateDAOImpl<T> implements Dao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class entityClass;

    public HibernateDAOImpl(Class entityClass){
        this.entityClass = entityClass;
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
        //return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @SuppressWarnings("uncheked")
    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void saveObject(T entity) {
        getSession().saveOrUpdate(entity);
    }

    public void deleteObject(T entity) {
        getSession().delete(entity);
    }

    public void deleteObject(String id) {
        getSession().delete(getObject(id));
    }

    public T getObject(String id) {
        return (T) getSession().get(getEntityClass(),id);
    }

}
