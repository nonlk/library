package ru.courseProject.library.maper;

import org.apache.ibatis.annotations.*;
import ru.courseProject.library.model.LogPas;
import ru.courseProject.library.model.Reader;


@Mapper
public interface AuthenticationMapper {

    @Select("SELECT pass FROM readers_log_pas WHERE login = #{log}")
    @Result(property = "pass", column = "pass")
    String findPasByLogin(String log);

    @Select("SELECT COUNT(*) FROM readers")
    Integer countReaders();

    @Insert("INSERT INTO readers_log_pas(login, reader_id, pass)" +
            " VALUES (#{login}, #{readerId}, #{pass})")
    int insertLogPas(LogPas logPas);

    @Insert("INSERT INTO readers(first_name, second_name, last_name, read_card)" +
            " VALUES (#{firstName}, #{secondName}, #{lastName}, #{readCard})")
    int insertReader(Reader reader);

    @Select("SELECT reader_id FROM readers_log_pas" +
            " WHERE login = #{log} AND pass = #{pass}")
    @Result(property = "reader_id", column = "reader_id")
    Integer findReaderIdByLogAndPas(String log, String pass);

    @Select("SELECT CONCAT(first_name, ' ', second_name, ' ', last_name)" +
            " FROM readers " +
            "WHERE id = #{reader_id} ")
    @Result(property = "concat", column = "concat")
    String findFullNameByReaderId(Integer reader_id);
}
