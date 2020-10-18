package springboot.mapper;


import org.mapstruct.Mapper;
import springboot.dto.BookDTO;
import springboot.model.Book;

import java.util.List;

@Mapper(componentModel="spring")
public interface BookMapper {
     Book mapBook(BookDTO book);
     BookDTO mapBook(Book book);
     List<BookDTO> mapBook(List<Book> books);
}
