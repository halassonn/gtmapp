package com.github.britter.springbootherokudemo.api_controller;

import com.github.britter.springbootherokudemo.api_service.Datakaryawan_service;
import com.github.britter.springbootherokudemo.model.DataPegawai;
import com.github.britter.springbootherokudemo.repo_mod.DataPeg_repo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("/api")
@Transactional
public class DataPeg_con {
    @Autowired
    Datakaryawan_service datakaryawan_service;




    @PostMapping("/data_karyawan")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save_data (@Valid @RequestBody DataPegawai dataPegawai){
        return new ResponseEntity<>(datakaryawan_service.save(dataPegawai), HttpStatus.OK);
    }
    @PutMapping("/data_karyawan")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update_data (@Valid @RequestBody DataPegawai dataPegawai,@RequestParam ("id") String id){
        return new ResponseEntity<>(datakaryawan_service.update(dataPegawai,id), HttpStatus.OK);
    }
    @GetMapping("/data_karyawans")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> get_data_All() {
        return new ResponseEntity<>(datakaryawan_service.getAll(), HttpStatus.OK);
    }


    @GetMapping("/data_karyawan/by_nik")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> get_data_by_nik(@RequestParam(value = "nik") String nik, HttpServletRequest req) {
        return new ResponseEntity<>(datakaryawan_service.getby(req,nik), HttpStatus.OK);
    }
    @GetMapping("/data_karyawan/by_nama")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> get_data_by_nama(@RequestParam(value = "nama") String nama, HttpServletRequest req) {
        return new ResponseEntity<>(datakaryawan_service.getby(req,nama), HttpStatus.OK);
    }
    @DeleteMapping("/data_karyawan")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> delete(@RequestParam(value = "id") String id){
        return new ResponseEntity<>( datakaryawan_service.delete(id),HttpStatus.OK);
    }





}
