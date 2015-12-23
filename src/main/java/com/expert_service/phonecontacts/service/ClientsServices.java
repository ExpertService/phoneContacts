package com.expert_service.phonecontacts.service;

import com.expert_service.phonecontacts.domain.ClientsEntity;

import java.util.List;

/**
 * Интерфейс бизнес-уровня для досупа к классу сущности ClientsEntity
 * @version 1.0.0
 * @author Донченко Руслан
 */
public interface ClientsServices extends EntityService<ClientsEntity>{

    public List<ClientsEntity> getAllClientsWithPhones();

}
