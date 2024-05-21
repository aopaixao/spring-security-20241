package br.org.serratec.academia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.academia.entities.User;
import br.org.serratec.academia.records.CredenciaisLoginRecord;
import br.org.serratec.academia.records.JwtTokenRecord;
import br.org.serratec.academia.records.UserRecord;
import br.org.serratec.academia.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
    private UserService userService;

	@PostMapping("/signin")
	public ResponseEntity<JwtTokenRecord> authenticateUser(@RequestBody CredenciaisLoginRecord credenciaisLoginRecord) {
		JwtTokenRecord token = userService.authenticateUser(credenciaisLoginRecord);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

	@PostMapping("/signup")
	public ResponseEntity<User> registerUser(@RequestBody UserRecord userRecord) {
        return new ResponseEntity<>(userService.createUser(userRecord), HttpStatus.CREATED);
	}
}
