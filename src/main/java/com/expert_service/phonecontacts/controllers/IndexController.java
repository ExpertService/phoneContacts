package com.expert_service.phonecontacts.controllers;



import com.expert_service.phonecontacts.domain.ClientsEntity;
import com.expert_service.phonecontacts.domain.PhonesEntity;
import com.expert_service.phonecontacts.service.ClientsServices;
import com.expert_service.phonecontacts.service.ClientsServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Контроллер для обработки запросов. Пока состоит из одного метода, который возвращает страницу index.jsp со
 * списком клиентов с телефонами.
 * @version 1.0.0
 * @author Донченко Руслан
 */
@Controller
public class IndexController {

    @Autowired
    private ClientsServices clientsServices;

    @RequestMapping("/")
    public String listPhones(ModelMap model){
        List<ClientsEntity> contacts = clientsServices.getAllClientsWithPhones();
        model.addAttribute("contactsList", contacts);
        return "index";
    }
}