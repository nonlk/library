package ru.courseProject.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.courseProject.library.maper.AuthenticationMapper;
import ru.courseProject.library.model.LogPas;
import ru.courseProject.library.model.Reader;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    AuthenticationMapper authenticationMapper;

    public Map<String, String> registration(Map<String, String> request) {
        Map<String, String> response = new HashMap<>();

        //Проверка на существование введенного логина
        if (authenticationMapper.findPasByLogin(request.get("login")) != null) {
            response.put("created", "FAIL_LOGIN");
            return response;
        }

        //Формирование номера читательского билета
        String readCard = request.get("last_name").substring(0, 1).toUpperCase() +
                request.get("first_name").substring(0, 1).toUpperCase();

        //Формирование нового читателя
        Reader reader = new Reader(request.get("first_name"),
                request.get("second_name"), request.get("last_name"), "0");

        reader.setId(authenticationMapper.countReaders() + 1);

        readCard += reader.getId().toString();
        reader.setReadCard(readCard);

        //Формирование логина и пароля
        LogPas logPas = new LogPas(request.get("login"), request.get("pass"), reader.getId());

        //Проверка на запись в БД
        if (authenticationMapper.insertLogPas(logPas) > 0 && authenticationMapper.insertReader(reader) > 0) {
            response.put("created", "CREATED");
        } else {
            response.put("created", "BAD_REQUEST");
        }

        return response;
    }


    public Map<String, String> loginCheck(String login, String pass) {
        Map<String, String> response = new HashMap<>();
        response.put("authorisation", authenticationMapper.findFullNameByReaderId(
                authenticationMapper.findReaderIdByLogAndPas(login, pass)));
        if (response.get("authorisation") == null)
            response.put("authorisation", "FALSE");
        return response;
    }


}
