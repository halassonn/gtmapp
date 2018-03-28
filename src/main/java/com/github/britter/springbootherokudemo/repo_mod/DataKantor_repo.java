package com.github.britter.springbootherokudemo.repo_mod;

import com.github.britter.springbootherokudemo.model.DataKantor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataKantor_repo extends JpaRepository<DataKantor,String>{
    DataKantor findByNamakantor(String nama);
    DataKantor findByKodekantor(String kodekantor);
    boolean existsByKodekantor(String kodekantor);
    DataKantor getByKodekantor(String kodekantor);
    void deleteByKodekantor(String kodekantor);

}
