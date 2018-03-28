package com.github.britter.springbootherokudemo.api_controller;

import com.github.britter.springbootherokudemo.api_service.Datakantor_service;
import com.github.britter.springbootherokudemo.model.DataKantor;
import com.github.britter.springbootherokudemo.repo_mod.DataKantor_repo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class DataKan_con {

    @Autowired
    Datakantor_service datakantor_service;

    @PostMapping("/data_kantor")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addDataKantor(@Valid @RequestBody DataKantor dataKantor) {
        return new ResponseEntity<>(datakantor_service.save(dataKantor), HttpStatus.OK);
    }

    @PutMapping("/data_kantor")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateDataKantor(@Valid @RequestBody DataKantor dataKantor, @RequestParam("id") String id) {
        return new ResponseEntity<>(datakantor_service.update(dataKantor,id), HttpStatus.OK);
    }

    @GetMapping("/data_kantors")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getDatakantors() {
        return new ResponseEntity<>(datakantor_service.getAllDatakantor(), HttpStatus.OK);
    }

    @GetMapping(value = "/data_kantor/by_kode")
    public ResponseEntity<?> getDataKantorBykode(@RequestParam("kode_kantor") String kodekantor, HttpServletRequest req) {
        return new ResponseEntity<>( datakantor_service.getDatakantor(req, kodekantor), HttpStatus.OK);
    }

    @GetMapping(value = "/data_kantor/by_nama")
    public ResponseEntity<?> getDataKantorBynama(@RequestParam("nama_kantor") String namakantor, HttpServletRequest req) {
        return new ResponseEntity<>(datakantor_service.getDatakantor(req,namakantor), HttpStatus.OK);
    }

    @DeleteMapping("/data_kantor")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> delete(@RequestParam("id") String id) {
        return new ResponseEntity<Object>(datakantor_service.delete(id),HttpStatus.OK);
    }





}
