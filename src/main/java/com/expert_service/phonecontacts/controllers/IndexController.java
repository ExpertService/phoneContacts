package com.expert_service.phonecontacts.controllers;

import com.expert_service.phonecontacts.domain.ClientsEntity;
import com.expert_service.phonecontacts.domain.PhonesEntity;
import com.expert_service.phonecontacts.service.ClientsServices;
import com.expert_service.phonecontacts.service.ClientsServicesImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Response;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * Контроллер для обработки запросов. Пока состоит из одного метода, который возвращает страницу index.jsp со
 * списком клиентов с телефонами.
 * @version 1.0.0
 * @author Донченко Руслан
 */
@Controller("indexController")
public class IndexController {

    @Autowired
    private ClientsServices clientsServices;
    private static final Logger log = LogManager.getLogger(IndexController.class.getName());

    @RequestMapping(value = "/ajaxUpdate", method = RequestMethod.POST)
    public @ResponseBody String ajaxUpdate(@RequestBody String changedContacts) {
        log.info("Controller have got ajaxUpdate request!");
        try {
            String encodedString = URLDecoder.decode(changedContacts, "UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            List<ClientsEntity> clientsFromPage = mapper.readValue(encodedString, new TypeReference<List<ClientsEntity>>() {});
            for (ClientsEntity clientFromPage:
                    clientsFromPage) {
                ClientsEntity clientForUpdate = clientsServices.getEntityById(ClientsEntity.class, clientFromPage.getIdClient());
                clientForUpdate.setClientFio(clientFromPage.getClientFio());
                clientForUpdate.getPhone().setPhoneNumber(clientFromPage.getPhone().getPhoneNumber());
                clientForUpdate.getPhone().setPhoneType(clientFromPage.getPhone().getPhoneType());
                clientForUpdate.getPhone().setComment(clientFromPage.getPhone().getComment());
                clientsServices.saveEntity(clientForUpdate);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            log.info("UnsupportedEncodingException need proccessing!");
        } catch (JsonParseException e) {
            e.printStackTrace();
            log.info("JsonParseException need proccessing!");
        } catch (JsonMappingException e) {
            e.printStackTrace();
            log.info("JsonMappingException need proccessing!");
        } catch (IOException e) {
            e.printStackTrace();
            log.info("IOException need proccessing!");
        }
        return "true";
    }

    @RequestMapping("/")
    public String listPhones(ModelMap model){
        List<ClientsEntity> contacts = clientsServices.getAllClientsWithPhones();
        log.info("Controller have got index request!");
        model.addAttribute("contactsList", contacts);
        return "index";
    }
}