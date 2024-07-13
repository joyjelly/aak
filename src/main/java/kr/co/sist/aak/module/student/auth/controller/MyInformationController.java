package kr.co.sist.aak.module.student.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyInformationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/mypage/verify_password.do")
    public ResponseEntity<?> verifyPassword(@RequestParam("password") String password) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(currentUsername, password);
        
        try {
            authenticationManager.authenticate(authToken);
            return ResponseEntity.ok().body("success");
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid");
        }
    }
}
