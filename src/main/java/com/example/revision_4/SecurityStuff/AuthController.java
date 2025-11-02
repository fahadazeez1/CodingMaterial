package com.example.revision_4.SecurityStuff;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginresposeDto> login(@RequestBody LoginRequestDtoo loginRequestDtoo){
        return  ResponseEntity.ok(authService.chklogin(loginRequestDtoo));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupesposeDto> signup(@RequestBody LoginRequestDtoo signupRequestDtoo){
        return  ResponseEntity.ok(authService.signup(signupRequestDtoo));
    }

}
