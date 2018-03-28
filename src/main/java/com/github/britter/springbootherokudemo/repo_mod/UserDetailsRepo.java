package com.github.britter.springbootherokudemo.repo_mod;

import com.github.britter.springbootherokudemo.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<UserDetails,String> {
    boolean existsByEmail(String email);
    boolean existsByNik(String nik);
    UserDetails findByEmail(String email);


}