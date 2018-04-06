package com.github.britter.springbootherokudemo.api_controller;


import com.github.britter.springbootherokudemo.api_service.Setting_service;
import com.github.britter.springbootherokudemo.model.Setting_model;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/api")
public class SettingController {

    @Autowired
    Setting_service setting_service;

    @PostMapping("/tunjangan_kesehatan")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addTnjKesehatan(@Validated @RequestBody Setting_model setting_model){
        return new ResponseEntity<>(setting_service.save(setting_model),HttpStatus.CREATED);
    }
    @PutMapping("/tunjangan_kesehatan")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateTnjKesehatan(@Validated @RequestBody Setting_model setting_model){
        return new ResponseEntity<>(setting_service.update(setting_model),HttpStatus.OK);
    }
    @GetMapping("/tunjangan_kesehatans")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getall(){
        return new ResponseEntity<>(setting_service.getall(),HttpStatus.OK);
    }
    @GetMapping("/tunjangan_kesehatan/by_id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?>getbyId(@RequestParam("id") String id, HttpServletRequest req){
        return new ResponseEntity<>(setting_service.getby(req,id),HttpStatus.OK);
    }
}
