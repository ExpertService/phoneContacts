package com.expert_service.phonecontacts.dao.common;

import java.util.List;

/**
 * Интерфейс для реализации базовых операций с сущностями
 * @version 1.0.0
 * @author Донченко Руслан
 */
public interface Dao<T> {

    public void saveObject(T entity);

    public void deleteObject(T entity);

    public void deleteObject(String id);

    public T getObject(String id);

    public List<T> getObjects();

}
