package ru.courseProject.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.courseProject.library.service.AuthenticationService;

import java.util.Map;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController (AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> registration(@RequestBody Map<String, String> request) {
        if (authenticationService.registration(request).get("created") == "CREATED")
            return new ResponseEntity<>(HttpStatus.CREATED);
        else if (authenticationService.registration(request).get("created") == "FAIL_LOGIN")
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "authorisation", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> authorisation(@RequestParam String login,
                                                @RequestParam String pass) {
        return authenticationService.loginCheck(login, pass).get("authorisation") == "FALSE" ?
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED) :
                new ResponseEntity<>("Добро пожаловать, " +
                        authenticationService.loginCheck(login, pass).get("authorisation") + "!",
                        HttpStatus.OK);
    }
}
