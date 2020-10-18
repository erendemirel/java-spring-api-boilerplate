package springboot.service;

import springboot.model.Book;

import java.util.List;

public interface BookService {

    public Book findByBookId(int bookIdToSearchFor);

    List<Book> findAllBooks();

    boolean doesSameIdExists(Book book);

    boolean checkIfBookExists(Book book);

    Book saveABook(Book book);
}
