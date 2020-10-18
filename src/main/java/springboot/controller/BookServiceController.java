package springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.dto.BookDTO;
import springboot.mapper.BookMapper;
import springboot.model.Book;
import springboot.service.BookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api("Book Service")
public class BookServiceController {

    public static final Logger logger = LoggerFactory.getLogger(BookServiceController.class);

    @Autowired
    BookService bookService;

    @Autowired
    BookMapper bookMapper;


    /**
     * Retrieve a book by id
     *
     * @param bookId given book
     * @return A single book
     */
    @ApiOperation("Returns a single book with given id")
    @RequestMapping(value = "/books/{book_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSpecificType(@PathVariable("book_id") int bookId) {
        Book singleBook = bookService.findByBookId(bookId);
        if (singleBook == null) {
            return new ResponseEntity<>(bookId, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(singleBook, HttpStatus.OK);
    }

    /**
     * Retrieve all books
     *
     * @param
     * @return list consists of books which returns all books which have been posted, HTTP status OK(200)
     */
    @ApiOperation("List all books")
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<?> listAllBooks() {
        List<Book> allBooks = bookService.findAllBooks();
        if (allBooks.isEmpty()) {
            return null;
        }
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    /**
     * Save a book
     *
     * @param book - Book to be created
     * @return book created, HTTP status CREATED(201), HTTP status BAD_REQUEST(400)
     */
    @ApiOperation("Insert a book")
    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    public ResponseEntity<?> insertABook(@Valid @RequestBody BookDTO book) {
        Book convertedBook = bookMapper.mapBook(book);
        bookService.saveABook(convertedBook);
        return new ResponseEntity<>(bookService.findByBookId(convertedBook.getId()), HttpStatus.CREATED);
    }
}
