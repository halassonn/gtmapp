package com.github.britter.springbootherokudemo.repo_mod;

import com.github.britter.springbootherokudemo.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
    User getByUsername (String username);
}
