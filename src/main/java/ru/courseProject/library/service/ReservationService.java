package ru.courseProject.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.courseProject.library.maper.ReservationMapper;
import ru.courseProject.library.model.Book;
import ru.courseProject.library.model.Reservation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;

    public List<Book> booksSearch (String param) {
        List<Book> books = reservationMapper.findByParam(param);
        return books;
    }

    public Map<String, String> reserv (Map<String, Object> request) {
        Map<String, String> response = new HashMap<>();
        Reservation reservation = new Reservation();
        request.forEach((s, o) -> {
            switch (s) {
                case "reader_id":
                    Integer readerId = Integer.valueOf(o.toString());
                    if (reservationMapper.findReadCardByReaderId(readerId) != null) {
                        reservation.setReaderCard(reservationMapper.findReadCardByReaderId(readerId));
                    } else response.put("reservation", "FAIL_READER");
                    break;
                case "book_id":
                    reservation.setBookId(Integer.parseInt(o.toString()));
                    break;
                case "reserv_date":
                    reservation.setDate(o.toString());
                    break;
                case "reserv_time":
                    reservation.setTime(o.toString());
                    break;
                case "verification":
                    Boolean verification = Boolean.valueOf(o.toString().toUpperCase());
                    reservation.setVerification(verification);
                    break;
            }
        });

        if (reservationMapper.findBookNameAndAuthorById(reservation.getBookId()) != null &&
            reservationMapper.findBookQtyById(reservation.getBookId()) > 0 && response.get("reservation") != "FAIL_READER" && reservation.getVerification() == Boolean.TRUE) {
            if (reservationMapper.insertReservation(reservation) > 0) {
                reservationMapper.updateQty(reservation.getBookId());
                response.put("reservation", reservationMapper.findBookNameAndAuthorById(reservation.getBookId())
                        + " забронирована Вами на " + reservation.getDate() + " " + reservation.getTime());
            }
            else response.put("reservation", "BAD_REQUEST");
        }
        else response.put("reservation", "BAD_REQUEST");
        return response;
    }

}
