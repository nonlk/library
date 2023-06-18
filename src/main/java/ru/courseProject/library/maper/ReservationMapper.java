package ru.courseProject.library.maper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.courseProject.library.model.Book;

@Mapper
public interface ReservationMapper {

    @Select("SELECT * FROM books WHERE book_name = #{param} OR author_name = #{param}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "book_name", column = "book_name"),
            @Result(property = "author_name", column = "author_name"),
            @Result(property = "qty", column = "qty")
    })
    Book findByParam(String param);

    @Select("SELECT read_card FROM readers WHERE id = #{id}")
    @Result(property = "read_card", column = "read_card")
    Integer findReadCardByReaderId(Integer id);

}
