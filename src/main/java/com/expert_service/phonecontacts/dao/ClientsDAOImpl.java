package com.expert_service.phonecontacts.dao;

import com.expert_service.phonecontacts.dao.hibernate.HibernateDAOImpl;
import com.expert_service.phonecontacts.domain.ClientsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Класс реализовывает все операции с сущностью {@link com.expert_service.phonecontacts.domain.ClientsEntity Клиенты}
 * @version 1.0.0
 * @author Донченко Руслан
 */
@Repository
public class ClientsDAOImpl extends HibernateDAOImpl<ClientsEntity> implements ClientsDAO{

    @Autowired
    /**
     * Конструктор объекта, в параметр которого внедряется значение типа сущности
     * @param  класс сущности ClientsEntity*/
    public ClientsDAOImpl(@Value("com.expert_service.phonecontacts.domain.ClientsEntity") Class ClientsEntity) {
        super(ClientsEntity);
    }

    /**
     * Метод возвращает список клиентов с телефонами. Для выборки используются именованный запрос,
     * определенный в классе-сущности ClientsEntity*/
    public List<ClientsEntity> getAllClientsWithPhones() {
        return getSession().getNamedQuery("Clients.ClientsWithPhones").list();
    }

    public List<ClientsEntity> getObjects() {
        return getSession().getNamedQuery("Clients.ClientsList").list();
    }
}
