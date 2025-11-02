package com.example.revision_4.SecurityStuff;

import com.example.revision_4.Entity.User;
import jakarta.websocket.server.ServerEndpoint;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final HandlerExceptionResolver handlerExceptionResolver;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final AuthUtil authUtil;
    private  final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    public LoginresposeDto chklogin(LoginRequestDtoo loginRequestDtoo) {

        Authentication authentication =authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(loginRequestDtoo.getUsername(),loginRequestDtoo.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        String token = authUtil.getAccessToken(user);
       return new LoginresposeDto(token,user.getId());

    }

    public SignupesposeDto signup(LoginRequestDtoo signupRequestDtoo) {



        User user = userRepo.findByUsername(signupRequestDtoo.getUsername()).orElse(null);

            if(user!=null) throw  new BadCredentialsException("already exist");


        user= userRepo.save(User.builder()
                        .username(signupRequestDtoo.getUsername())
                        .role("ADMIN")
                        .password(passwordEncoder.encode(signupRequestDtoo.getPassword()))
                        .build()


                );
        return new SignupesposeDto(user.getUsername(),user.getId());


    }
}
