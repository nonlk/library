package ru.courseProject.library.maper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.courseProject.library.model.LogPas;
import ru.courseProject.library.model.Reader;

import java.util.List;
import java.util.Optional;

public interface AuthenticationMapper {

    @Select("SELECT password FROM readers_log_pas WHERE login = #{log}")
    @Result(property = "password", column = "password")
    Optional<String> findPasByLogin(String log);

    @Select("SELECT COUNT(*) FROM readers")
    Integer countReaders();

    @Insert("INSERT INTO readers_log_pas(login, reader_id password) " +
            " VALUES (#{login}, #{reader_id} #{password})")
    int insertLogPas(LogPas logPas);

    @Insert("INSERT INTO readers(first_name, second_name, last_name, read_card)" +
            " VALUES (#{first_name}, #{second_name}, #{last_name), #{read_card})")
    int insertReader(Reader reader);

    @Select("SELECT reader_id FROM readers_log_pas" +
            " WHERE login = #{log} AND password = #{pass}")
    @Result(property = "reader_id", column = "reader_id")
    Integer findReaderIdByLogAndPas(String log, String pass);

    @Select("SELECT CONCAT(first_name, ' ', second_name, ' ', last_name)" +
            " FROM readers rs JOIN readers_log_pas rslp " +
            "WHERE rs.id = rslp.reader_id AND rs.id = #{reader_id} ")
    @Results({
            @Result(property = "first_name", column = "first_name"),
            @Result(property = "second_name", column = "second_name"),
            @Result(property = "last_name", column = "last_name")
    })
    String findFullNameByReaderId(Integer reader_id);

    @Select("SELECT * FROM readers_log_pas")
    @Results({
            @Result(property = "login", column = "login"),
            @Result(property = "reader_id", column = "reader_id"),
            @Result(property = "password", column = "password")
    })
    List<LogPas> findAllLogPas();

}
