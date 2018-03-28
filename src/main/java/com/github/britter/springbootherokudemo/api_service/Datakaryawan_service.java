package com.github.britter.springbootherokudemo.api_service;


import com.github.britter.springbootherokudemo.model.DataPegawai;
import com.github.britter.springbootherokudemo.repo_mod.DataPeg_repo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Component
@Transactional
public class Datakaryawan_service {

    @Autowired
    DataPeg_repo dataPegawai_repo;

    List<DataPegawai> dataPegawaiList;
    DataPegawai dataPegawai;

    //get all
    public ResponseEntity<?> getAll() {
        dataPegawaiList = new ArrayList<>();
        dataPegawaiList = dataPegawai_repo.findAll();
        System.out.println(dataPegawaiList.toString());
        if (dataPegawaiList == null) {
            return new ResponseEntity<>("Data not found", HttpStatus.OK);
        }
        return new ResponseEntity<>(dataPegawaiList, HttpStatus.OK);
    }

    //get data kantor by
    public ResponseEntity<?> getby(HttpServletRequest req, String p) {
        dataPegawai = new DataPegawai();
        Enumeration parameter = req.getParameterNames();
        String param_name = (String) parameter.nextElement();
        if (param_name.equals("nik")) {
            dataPegawai = dataPegawai_repo.getByNik(p);

        } else if (param_name.equals("nama")) {
            dataPegawai = dataPegawai_repo.getByNama(p);

        }
        if (dataPegawai == null) {
            return new ResponseEntity<>("Data not found", HttpStatus.OK);
        }
        return new ResponseEntity<>(dataPegawai, HttpStatus.OK);
    }

    //save and update
    public ResponseEntity<?> save(DataPegawai dataPegawai) {
        if(!dataPegawai.getEmail().equals("") && dataPegawai_repo.existsByEmail(dataPegawai.getEmail())){
            return new ResponseEntity<>("Email sudah digunakan", HttpStatus.CONFLICT);
        }
        System.out.println(dataPegawai);

            dataPegawai_repo.save(dataPegawai);
            return new ResponseEntity<>("Data save succesfully", HttpStatus.CREATED);

    }
    public ResponseEntity<?> update(DataPegawai dataPegawai, String id) {
        dataPegawai_repo.saveAndFlush(dataPegawai);
        return new ResponseEntity<>("Data update succesfully", HttpStatus.OK);
    }

    //delete
    public ResponseEntity<?> delete(String id) {
        dataPegawai_repo.delete(id);
        return new ResponseEntity<>("Data delete succesfully", HttpStatus.OK);
    }


}
