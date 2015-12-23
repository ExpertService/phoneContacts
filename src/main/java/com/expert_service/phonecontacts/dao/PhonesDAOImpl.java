package com.expert_service.phonecontacts.dao;

import com.expert_service.phonecontacts.dao.hibernate.HibernateDAOImpl;
import com.expert_service.phonecontacts.domain.PhonesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * Класс реализовывает все операции с сущностью {@link com.expert_service.phonecontacts.domain.PhonesEntity Клиенты}
 * @version 1.0.0
 * @author Донченко Руслан
 */
public class PhonesDAOImpl extends HibernateDAOImpl<PhonesEntity> {

    @Autowired
    public PhonesDAOImpl(@Value("com.expert_service.phonecontacts.domain.PhonesEntity")Class PhonesEntity) {
        super(PhonesEntity);
    }


    public List<PhonesEntity> getObjects() {
        return getSession().getNamedQuery("Phones.PhonesList").list();
    }
}
