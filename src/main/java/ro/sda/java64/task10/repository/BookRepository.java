package ro.sda.java64.task10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.java64.task10.entity.Book;


import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long>{
    List<Book> findAllByTitle(String title);
    Optional<Book> findFirstByIsbn(String isbn);

}
