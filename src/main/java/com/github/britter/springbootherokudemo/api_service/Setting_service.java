package com.github.britter.springbootherokudemo.api_service;

import com.github.britter.springbootherokudemo.model.Setting_model;
import com.github.britter.springbootherokudemo.repo_mod.Setting_repo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Component
@Transactional
public class Setting_service {
    @Autowired
    Setting_repo setting_repo;
    Setting_model setting_model;
    List<Setting_model> setting_modelList;

    public ResponseEntity<?> save(Setting_model setting_model){
        if(setting_repo.existsByStatus(setting_model.getstatus())){
            return new ResponseEntity<>("Data dengan status "+ setting_model.getstatus() +" sudah ada" , HttpStatus.CONFLICT);
        }
        setting_repo.save(setting_model);
        return new ResponseEntity<>("Data berhasil di simpan",HttpStatus.CREATED);
    }

    public ResponseEntity<?> getall(){
        setting_modelList = new ArrayList<>();
        setting_modelList= setting_repo.findAll();
        if(setting_modelList == null){
            return new ResponseEntity<>("Data tidak di temukan",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(setting_modelList,HttpStatus.OK);
    }

    public ResponseEntity<?> getby(HttpServletRequest req,String id){
       setting_model = new Setting_model();

        Enumeration parameter = req.getParameterNames();
        String param_name = (String) parameter.nextElement();
        if(param_name.equals("id")){
            setting_model= setting_repo.findOne(id);
        }
        if(setting_model == null){
            return new ResponseEntity<>("Data tidak di temukan",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(setting_model,HttpStatus.OK);
    }

    public ResponseEntity<?> update(Setting_model setting_model){
        this.setting_model = setting_repo.findOne(setting_model.getId());
        if(this.setting_model == null){
            return new ResponseEntity<>("Data "+setting_model.getstatus()+" tidak di temukan",HttpStatus.NOT_FOUND);
        }
        setting_repo.saveAndFlush(setting_model);
        return new ResponseEntity<>("Data berhasil di update",HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Setting_model setting_model){
        this.setting_model = setting_repo.findOne(setting_model.getId());
        if(this.setting_model == null){
            return new ResponseEntity<>("Data "+setting_model.getstatus()+" tidak di temukan",HttpStatus.NOT_FOUND);
        }
        setting_repo.delete(setting_model.getId());
        return new ResponseEntity<>("Data " + setting_model.getstatus() + " berhasil di hapus", HttpStatus.OK);
    }
}
