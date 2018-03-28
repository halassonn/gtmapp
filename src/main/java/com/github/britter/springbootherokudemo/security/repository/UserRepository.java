package com.github.britter.springbootherokudemo.security.repository;

import com.github.britter.springbootherokudemo.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByKode(String kode);
    User getByKode(String kode);
    User findByAuthorities_Name(String name);
    boolean existsByUserDetails_Email(String Email);
    User findByUserDetails_Email(String email);
    User findByUserDetails_Id(String id);
}
