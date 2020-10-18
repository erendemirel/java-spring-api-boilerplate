package springboot.service;

import org.springframework.stereotype.Service;
import springboot.customexceptions.BookAlreadyExistsException;
import springboot.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    private static List<Book> books = new ArrayList<>();


    @Override
    public Book findByBookId(int bookIdToSearchFor) {
        return books.stream().filter(book -> book.getId() == bookIdToSearchFor).findFirst().orElse(null);
    }

    @Override
    public List<Book> findAllBooks() {
        return books;
    }

    @Override
    public boolean doesSameIdExists(Book book) {
        return findByBookId(book.getId()) != null;
    }

    @Override
    public boolean checkIfBookExists(Book book) {
        for (Book aBook : books) {
            if ((aBook.getAuthor().equals(book.getAuthor())) && (aBook.getTitle().equals(book.getTitle()))) {
                throw new BookAlreadyExistsException("Another book with similar title and author already exists.");
            }
        }
        return false;
    }

    @Override
    public Book saveABook(Book book) {
        Optional<Book> maxbook = books.stream().max((o1, o2) -> o1.getId().compareTo(o2.getId()));
        if (maxbook.isPresent()) {
            book.setId(maxbook.get().getId() + 1);
        } else {
            book.setId(1);
        }
        checkIfBookExists(book);
        books.add(book);
        return book;
    }

}
