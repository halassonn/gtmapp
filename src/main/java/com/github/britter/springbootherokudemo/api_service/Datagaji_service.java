package com.github.britter.springbootherokudemo.api_service;


import com.github.britter.springbootherokudemo.model.DataGaji;
import com.github.britter.springbootherokudemo.repo_mod.GajiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class Datagaji_service {
    @Autowired
    GajiRepo gajiRepo;
    DataGaji dataGaji;
    List<DataGaji> dataGajiList;


    //get all gaji
    public ResponseEntity<?> getallgaji(){
        dataGajiList = new ArrayList<>();
        dataGajiList = gajiRepo.findAll();
        if(dataGajiList == null){
            return new ResponseEntity<>("Data tidak di temukan", HttpStatus.OK);
        }
        return new ResponseEntity<>(dataGajiList, HttpStatus.OK);
    }

    // get gaji by nik
    public ResponseEntity<?> getgajibynik(String nik){
        dataGaji = new DataGaji();
        dataGaji = gajiRepo.getByDataPegawai_nik(nik);
        if(dataGaji ==null){
            return new ResponseEntity<>("Data tidak di temukan",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dataGaji,HttpStatus.OK);
    }

    //get all gaji by tgl
    public ResponseEntity<?> getallbytgl(Date tglgaji){
        dataGajiList = new ArrayList<>();
        dataGajiList = gajiRepo.getByTglgaji(tglgaji);
        if(dataGajiList == null){
            return new ResponseEntity<>("Data tidak di temukan",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dataGajiList,HttpStatus.OK);
    }

    //save and update

    public ResponseEntity<?> save(DataGaji dataGaji){
        if(gajiRepo.existsByTglgajiAndDataPegawai_nik(dataGaji.getTglgaji(),dataGaji.getDataPegawai().getNik())){
            return new ResponseEntity<>("Data gaji dengan nik " + dataGaji.getDataPegawai().getNik() + " sudah ada",HttpStatus.CONFLICT);
        }
        gajiRepo.save(dataGaji);
        return new ResponseEntity<>("Data berhasil di simpan",HttpStatus.CREATED);
    }

    public ResponseEntity<?> update(DataGaji dataGaji){
        gajiRepo.saveAndFlush(dataGaji);
        return new ResponseEntity<>("Data berhasil di update",HttpStatus.OK);
    }
    // hapus
    public ResponseEntity<?> hapus(String id){
        gajiRepo.delete(id);
        return new ResponseEntity<>("Data berhasi di hapus",HttpStatus.OK);
    }




}
