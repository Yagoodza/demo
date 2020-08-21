package com.yagudza.demo.controllers;

import com.yagudza.demo.dto.dtoIn.UserDtoIn;
import com.yagudza.demo.dto.dtoOut.UserDtoOut;
import com.yagudza.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserDtoOut> addUser(@RequestBody UserDtoIn userDtoIn) {
        return ResponseEntity.ok(userService.save(userDtoIn));
    }

    @DeleteMapping("user/{id}")
    @Transactional
    public ResponseEntity<?> userRemove(@PathVariable(value = "id") long id) {
        if (!userService.existsById(id)){
            return ResponseEntity.noContent().build();
        }
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAllUsers")
    public ResponseEntity<Iterable<UserDtoOut>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }
}
