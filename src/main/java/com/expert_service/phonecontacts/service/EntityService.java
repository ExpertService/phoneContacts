package com.expert_service.phonecontacts.service;

import java.util.List;

/**
 * Интерфейс уровня бизнесс-логики для доступа к операциям с сущностями
 * @version 1.0.0
 * @author Донченко Руслан
 */
public interface EntityService <T> {
    public T getEntityById(Class entityClass, String id);
    public void saveEntity(T entity);
    public void deleteEntity(T entity);
    public void updateEntity(T entity);
    public List<T> getListOfEntities();
}
