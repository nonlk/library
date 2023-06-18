package ru.courseProject.library.maper;

import org.apache.ibatis.annotations.*;
import ru.courseProject.library.model.Book;
import ru.courseProject.library.model.Reservation;

import java.util.List;

@Mapper
public interface ReservationMapper {

    @Select("SELECT * FROM books WHERE book_name = #{param} OR author_name = #{param}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "authorName", column = "author_name"),
            @Result(property = "qty", column = "qty")
    })
    List<Book> findByParam(String param);

    @Select("SELECT qty FROM books WHERE id = #{id}")
    @Result(property = "qty", column = "qty")
    Integer findBookQtyById(Integer id);

    @Select("SELECT read_card FROM readers WHERE id = #{id}")
    @Result(property = "read_card", column = "read_card")
    String findReadCardByReaderId(Integer id);

    @Select("SELECT CONCAT(book_name, ' ', author_name) FROM books WHERE id = #{id}")
    @Result(property = "concat", column = "concat")
    String findBookNameAndAuthorById(Integer id);

    @Insert("INSERT INTO reservation(reader_card, book_id, reserv_date, reserv_time) " +
            "VALUES(#{readerCard}, #{bookId}, #{date}, #{time})")
    int insertReservation(Reservation reservation);

    @Update("UPDATE books SET qty = qty-1 WHERE id = #{id}")
    Boolean updateQty(Integer id);
}
