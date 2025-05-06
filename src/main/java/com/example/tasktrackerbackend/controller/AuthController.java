
/*
package com.example.tasktrackerbackend.controller;
import com.example.tasktrackerbackend.data.User;
import com.example.tasktrackerbackend.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtils jwtUtils;

    // POST /api/auth/register
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        return ResponseEntity.ok("User registered successfully");
    }

    // POST /api/auth/login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        String jwt = jwtUtils.generateJwtToken(user.getUsername());
        return ResponseEntity.ok(jwt);
    }

    // DELETE /api/auth/logout
    @DeleteMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("User logged out successfully");
    }
}

 */
