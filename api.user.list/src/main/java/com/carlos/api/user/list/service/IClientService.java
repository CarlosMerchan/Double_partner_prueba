package com.carlos.api.user.list.service;

import org.springframework.http.ResponseEntity;

public interface IClientService {

     ResponseEntity<?> getProfileByName(String name);
}
