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

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "registration", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> registration(@RequestBody Map<String, String> request) {
        Map<String, Boolean> response = authenticationService.registration(request);
        if (response.get("created") == Boolean.TRUE) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
