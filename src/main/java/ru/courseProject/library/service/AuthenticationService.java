package ru.courseProject.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.courseProject.library.maper.AuthenticationMapper;
import ru.courseProject.library.model.LogPas;
import ru.courseProject.library.model.Reader;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    AuthenticationMapper authenticationMapper;

    public Map<String, Boolean> registration(Map<String, String> request) {
        Map<String, Boolean> response = new HashMap<>();
        if (authenticationMapper.findPasByLogin(request.get("login")).isPresent()) {
            response.put("created", Boolean.FALSE);
            return response;
        }

        String readCard = request.get("last_name").substring(0, 1).toUpperCase() +
                request.get("first_name").substring(0, 1).toUpperCase();

        Reader reader = new Reader(request.get("first_name"),
                request.get("second_name"), request.get("last_name"), "0");

        reader.setId(authenticationMapper.countReaders() + 1);

        readCard += reader.getId().toString();

        reader.setReadCard(readCard);
        LogPas logPas = new LogPas(request.get("login"), request.get("password"));

        if (authenticationMapper.insertReader(reader) > 0 && authenticationMapper.insertLogPas(logPas) > 0) {
            response.put("created", Boolean.TRUE);
        } else {
            response.put("created", Boolean.FALSE);
        }
        return response;
    }
}
