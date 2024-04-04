package ro.sda.java64.task10.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.sda.java64.task10.entity.Book;
import ro.sda.java64.task10.repository.BookRepository;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BooksController {
    private final BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @PostMapping
    public Book saveBook(@RequestBody Book req){
        return bookRepository.save(req);
    }

    @PostMapping("/title")
    public List<Book> findByTitle(@RequestBody SearchRequest req){
        return bookRepository.findAllByTitle(req.getTitle());
    }

    @PostMapping("/isbn")
    public Book findByIsbn(@RequestBody SearchRequest req) {
        return bookRepository.findFirstByIsbn(req.getIsbn()).orElseThrow(() -> new RuntimeException("No books found!"));
    }
    @GetMapping("/pagesNum")
    public List<Book> findWherePagesNumIsGreaterThanX(@RequestParam Integer pages) {
//        bookRepository.findAllByAuthorAndIsbn("Fat frumos", "Ion Dobre");
        return bookRepository.findWherePagesNumIsGreaterThanX(pages);
    }

    @PostMapping("/author")
    public List<Book> findTop3BooksbyAuthor(@RequestBody SearchRequest req) {
//        bookRepository.findAllByAuthorAndIsbn("Fat frumos", "Ion Dobre");
        return bookRepository.findTop3ByAuthorOrderByPagesNumDesc(req.getAuthor());
    }
    @PostMapping("/titleStartsWith")
    public List<Book> titleStartsWith(@RequestBody SearchRequest req) {
        return bookRepository.findAllByTitleIgnoreCaseStartingWith(req.getTitle());
    }

    @GetMapping("/between")
    public List<Book> findAllByPagesNumBetween(@RequestParam Integer firstPage, @RequestParam Integer lastPage) {
        return bookRepository.findAllByPagesNumBetween(firstPage , lastPage);
    }


}
