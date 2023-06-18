package ru.courseProject.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.courseProject.library.model.Book;
import ru.courseProject.library.service.ReservationService;

import java.util.List;
import java.util.Map;
import java.util.Objects;


@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(value = "booksSearch", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Book>> bookSearch(@RequestParam String param) {
        List<Book> books = reservationService.booksSearch(param);
        return books != null && !books.isEmpty() ?
                new ResponseEntity<>(books, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "reserv", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> reserv (@RequestBody Map<String, Object> request) {
        String response = reservationService.reserv(request).get("reservation");

        if (response == "FAIL_READER")
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        if (response == "BAD_REQUEST")
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
