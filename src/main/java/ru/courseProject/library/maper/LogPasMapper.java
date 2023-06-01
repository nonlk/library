package ru.courseProject.library.maper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.courseProject.library.model.LogPas;

import java.util.List;

public interface LogPasMapper {

    @Select("SELECT password FROM readers_log_pas WHERE login = #{log}")
    @Result(property = "password", column = "password")
    String findPasByLogin(String log);

    @Select("SELECT reader_id FROM readers_log_pas" +
            " WHERE login = #{log} AND password = #{pass}")
    @Result(property = "reader_id", column = "reader_id")
    Integer findReaderIdByLogAndPas(String log, String pass);

    @Select("SELECT * FROM readers_log_pas")
    @Results({
            @Result(property = "login", column = "login"),
            @Result(property = "reader_id", column = "reader_id"),
            @Result(property = "password", column = "password")
    })
    List<LogPas> findAll();

}
