package com.expert_service.phonecontacts.service;

import com.expert_service.phonecontacts.dao.ClientsDAO;
import com.expert_service.phonecontacts.domain.ClientsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация интерфейса ClientServices для доступа к ClientsEntity через DAO-объект
 * @version 1.0.0
 * @author Донченко Руслан
 */
@Service
public class ClientsServicesImpl implements ClientsServices {

    @Autowired
    private ClientsDAO clientDAO;

    @Transactional
    public ClientsEntity getEntityById(Class entityClass, int id) {
        return clientDAO.getObject(id);
    }

    @Transactional
    public void saveEntity(ClientsEntity entity) {
        clientDAO.saveObject(entity);
    }

    @Transactional
    public void deleteEntity(ClientsEntity entity) {
        clientDAO.deleteObject(entity);
    }

    @Transactional
    public void updateEntity(ClientsEntity entity) {
        clientDAO.saveObject(entity);
    }

    public List<ClientsEntity> getListOfEntities() {
        return clientDAO.getObjects();
    }

    @Transactional
    public List<ClientsEntity> getAllClientsWithPhones() {
        return clientDAO.getAllClientsWithPhones();
    }
}
