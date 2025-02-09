package com.carlos.api.user.list.service.serviceImpl;

import com.carlos.api.user.list.model.Data;
import com.carlos.api.user.list.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class ClientServiceImpl implements IClientService {




    @Autowired
    private RestTemplate restTemplate;


    @Override
    public ResponseEntity<?> getProfileByName(String name) {

        if(name.isBlank()){
            HashMap<String,String> message = new HashMap<>();
            message.put("error","the name field cannot be empty");
            return ResponseEntity.badRequest().body(message);
        }

        ResponseEntity<Data> response =
                restTemplate.getForEntity("https://api.github.com/search/users?q=".concat(name), Data.class);

        return ResponseEntity.ok(response.getBody());
    }
}
