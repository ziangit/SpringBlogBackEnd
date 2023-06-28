package com.programming.zs.springngblog.controller;

//import dto.com.programming.zs.springngblog.LoginRequest;
//import dto.com.programming.zs.springngblog.RegisterRequest;
import com.programming.zs.springngblog.dto.LoginRequest;
import com.programming.zs.springngblog.service.AuthService;
import com.programming.zs.springngblog.service.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.programming.zs.springngblog.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

    @Autowired
    private AuthService authService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
//    public String login(@RequestBody LoginRequest loginRequest){
//        return authService.login(loginRequest);
//
//    }
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
