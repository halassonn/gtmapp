package com.github.britter.springbootherokudemo.helper.uniquejpa.service;

import com.github.britter.springbootherokudemo.model.DataKantor;
import com.github.britter.springbootherokudemo.repo_mod.DataKantor_repo;
import com.github.britter.springbootherokudemo.repo_mod.UserDetailsRepo;
import com.github.britter.springbootherokudemo.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniqueServices  implements UniqueServices_repo{

    @Autowired
    DataKantor_repo dataKantor_repo;
    @Autowired
    UserDetailsRepo userDetailsRepo;
    @Autowired
    UserRepository userRepository;
    public boolean unique_aktif=true;

    @Override
    public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {
        if (fieldName.equals("kodekantor")) {
                return this.dataKantor_repo.existsByKodekantor(value.toString());

        } else if (fieldName.equals("nik")) {
            return  this.userDetailsRepo.existsByNik(value.toString());
        } else if(fieldName.equals("username")){
            return this.userRepository.existsByUsername(value.toString());
        }
        else {
            return false;
        }
    }

    public boolean isUnique_aktif() {
        return unique_aktif;
    }

    public void setUnique_aktif(boolean unique_aktif) {
        this.unique_aktif = unique_aktif;
    }
}
