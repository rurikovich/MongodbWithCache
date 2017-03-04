package ru.sovcombank.openapi.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sovcombank.openapi.pojo.ApiClient;
import ru.sovcombank.openapi.repositories.ApiClientRepository;

import java.util.List;

/**
 * Created by rurik on 04/03/17.
 */

@RestController
public class ApiClientController {

    @Autowired
    ApiClientRepository apiClientRepository;

    @RequestMapping("/apiclients")
    public List<ApiClient> apiClients() {
        return apiClientRepository.findAll();
    }

    @RequestMapping("/apiclient")
    public ApiClient apiClient(@RequestParam(value = "id", defaultValue = "id0") String id) {
        return apiClientRepository.findById(id);
    }
}
