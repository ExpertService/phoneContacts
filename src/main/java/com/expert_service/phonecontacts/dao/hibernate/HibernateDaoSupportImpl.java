package com.expert_service.phonecontacts.dao.hibernate;

import com.expert_service.phonecontacts.dao.common.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.wiring.ClassNameBeanWiringInfoResolver;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Абстрактный класс - реализация интерфейса Dao. Все операции реализованы через
 * {@link org.springframework.orm.hibernate5.support.HibernateDaoSupport объект HibernateDaoSupport}
 * @version 1.0.0
 * @author Донченко Руслан
 */

public abstract class HibernateDaoSupportImpl<T> extends HibernateDaoSupport implements Dao<T> {

    @Autowired
    private SessionFactory sessionFactoryHibernateWithSpring;

    private Class entityClass;

    public HibernateDaoSupportImpl(Class entityClass){
        this.entityClass = entityClass;
    }

    public Class<T> getEntityClass(){
        return entityClass;
    }

    public void saveObject(T entity) {
        getHibernateTemplate().saveOrUpdate(entity);
    }

    public void deleteObject(T entity) {
        getHibernateTemplate().delete(entity);
    }

    public void deleteObject(Number id) {
        getHibernateTemplate().delete(getObject(id));
    }

    public T getObject(Number id) {
        return (T) getHibernateTemplate().get(getEntityClass(), id);
    }

    public List<T> getAllObjects() {
        return getHibernateTemplate().loadAll(getEntityClass());
    }

    public int getAllObjectsCount() {
        DetachedCriteria criteria = DetachedCriteria
                .forClass(getEntityClass())
                .setProjection(Projections.rowCount());
        return (Integer) getHibernateTemplate().findByCriteria(criteria).get(0);
    }
    @SuppressWarnings("unchecked")
    protected List<T> findByHQL(String hql, Object[] parameters){
        return (List<T>) getHibernateTemplate().find(hql, parameters);
    }

    public List<T> getObjects(String request, Object[] values) {
        return findByHQL(request, values);
    }
}
