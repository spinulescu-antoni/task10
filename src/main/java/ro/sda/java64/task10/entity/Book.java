package ro.sda.java64.task10.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity()
@Getter
@Setter
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String isbn;

    private Integer pagesNum;


}
