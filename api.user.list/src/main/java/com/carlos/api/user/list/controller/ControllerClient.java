package com.carlos.api.user.list.controller;

import com.carlos.api.user.list.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClient {

    @Autowired
    private IClientService clientService;

    @GetMapping("/getUsers/{name}")
    public ResponseEntity<?> getUsers(@PathVariable String name){
        return clientService.getProfileByName(name);
    }
}
