package com.github.britter.springbootherokudemo.api_service;

import com.github.britter.springbootherokudemo.helper.uniquejpa.service.UniqueServices;
import com.github.britter.springbootherokudemo.model.DataKantor;
import com.github.britter.springbootherokudemo.repo_mod.DataKantor_repo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Component
@Transactional
public class Datakantor_service {
    @Autowired
    DataKantor_repo dataKantor_repo;
    DataKantor dataKantor;
    List<DataKantor> dataKantorList;
    @Autowired
    UniqueServices uniqueServices;


    //get all
    public ResponseEntity<?> getAllDatakantor() {
        dataKantorList = new ArrayList<>();
        dataKantorList = dataKantor_repo.findAll();
        if (dataKantorList == null) {
            return new ResponseEntity<>("Data not found", HttpStatus.OK);
        }
        return new ResponseEntity<>(dataKantorList, HttpStatus.OK);
    }

    //get data kantor by
    public ResponseEntity<?> getDatakantor(HttpServletRequest req, String kodekantor) {
        dataKantor = new DataKantor();
        Enumeration parameter = req.getParameterNames();
        String param_name = (String) parameter.nextElement();
        if (param_name.equals("kode_kantor")) {
            dataKantor = dataKantor_repo.findByKodekantor(kodekantor);

        } else if (param_name.equals("nama_kantor")) {
            dataKantor = dataKantor_repo.findByNamakantor(kodekantor);

        }
        if (dataKantor == null) {
            return new ResponseEntity<>("Data not found", HttpStatus.OK);
        }
        return new ResponseEntity<>(dataKantor, HttpStatus.OK);
    }

    //save and update
    public ResponseEntity<?> save(DataKantor data) {
        if(dataKantor_repo.existsByKodekantor(data.getKodekantor())){
            return new ResponseEntity<>("Kode kantor sudah digunakan", HttpStatus.CONFLICT);
        }
        System.out.println(data);
            dataKantor_repo.save(data);
            return new ResponseEntity<>("Data berhasil di simpan", HttpStatus.CREATED);

    }
    public ResponseEntity<?> update(DataKantor data,String id) {
        //uniqueServices.setUnique_aktif(false);
        dataKantor_repo.saveAndFlush(data);
        return new ResponseEntity<>("Data berhasil di update", HttpStatus.OK);
    }

    //delete
    public ResponseEntity<?> delete(String id) {
        dataKantor_repo.delete(id);
        return new ResponseEntity<>("Data berhasil di hapus", HttpStatus.OK);
    }


}
