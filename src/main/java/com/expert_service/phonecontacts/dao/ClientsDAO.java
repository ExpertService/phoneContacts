package com.expert_service.phonecontacts.dao;

import com.expert_service.phonecontacts.dao.common.Dao;
import com.expert_service.phonecontacts.domain.ClientsEntity;

import java.util.List;

/**
 * Интерфейс для реализации операций относящихся к сущности "Клиенты"
 * @version 1.0.0
 * @author Донченко Руслан
 */
public interface ClientsDAO extends Dao<ClientsEntity> {
    /** Метод возвращает список клиентов вместе с телефонами
     * @return Список ClientsEntity
     * */
    public List<ClientsEntity> getAllClientsWithPhones();

    public List<ClientsEntity> getObjects();

}
