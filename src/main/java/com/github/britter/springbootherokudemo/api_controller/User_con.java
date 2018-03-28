package com.github.britter.springbootherokudemo.api_controller;

import com.github.britter.springbootherokudemo.model.security.User;
import com.github.britter.springbootherokudemo.repo_mod.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api")
@Transactional
public class User_con {
    @Autowired
    UserRepo userRepo;

    @GetMapping("/get-data-users")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<User>> getDataUsers () {
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }
    @GetMapping("/get-data-user/{username}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> getDataUser (@PathVariable String username) {
        return new ResponseEntity<>(userRepo.getByUsername(username), HttpStatus.OK);
    }
    @PostMapping("/add-data-user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> add(@RequestBody User user) {
        return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
    }
}
