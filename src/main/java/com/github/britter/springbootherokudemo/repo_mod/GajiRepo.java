package com.github.britter.springbootherokudemo.repo_mod;


import com.github.britter.springbootherokudemo.model.DataGaji;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface GajiRepo extends JpaRepository<DataGaji,String> {
    boolean existsByTglgajiAndDataPegawai_nik(Date tglgaji,String nik);
    DataGaji getByDataPegawai_nik(String nik);
    List<DataGaji> getByTglgaji(Date tglgaji);
}
