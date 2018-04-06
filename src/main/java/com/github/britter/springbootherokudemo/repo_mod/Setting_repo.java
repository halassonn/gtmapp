package com.github.britter.springbootherokudemo.repo_mod;

import com.github.britter.springbootherokudemo.model.Setting_model;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Setting_repo extends JpaRepository<Setting_model,String> {
    boolean existsByStatus(String p);
}