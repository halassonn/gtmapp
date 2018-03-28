package com.github.britter.springbootherokudemo.repo_mod;

import com.github.britter.springbootherokudemo.model.DataPegawai;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataPeg_repo extends JpaRepository<DataPegawai,String>{
    DataPegawai getByNik (String nik);
    DataPegawai getByNama (String nik);
    boolean existsByEmail (String email);
}
