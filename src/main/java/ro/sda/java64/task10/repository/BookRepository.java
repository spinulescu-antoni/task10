package ro.sda.java64.task10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.sda.java64.task10.entity.Book;


import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long>{
    List<Book> findAllByTitle(String title);
    Optional<Book> findFirstByIsbn(String isbn);

    List<Book> findAllByAuthorAndIsbn(String author,String isbn);
    List<Book> findTop3ByAuthorOrderByPagesNumDesc(String author);
    List<Book> findAllByPagesNumBetween(Integer firstPage, Integer lastPage);
    List<Book> findAllByTitleIgnoreCaseStartingWith(String title);

//    @Query(value = "select * from books b where b.pages_num>= :pageNums",nativeQuery = true)
    @Query(value = "select b from Book b where b.pagesNum >= :pageNums",nativeQuery = false)
    List<Book> findWherePagesNumIsGreaterThanX(@Param("pageNums") Integer number);

}
