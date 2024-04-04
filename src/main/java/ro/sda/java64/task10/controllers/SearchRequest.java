package ro.sda.java64.task10.controllers;

import lombok.Data;

@Data
public class SearchRequest {
    private String title;
    private String isbn;
    private String author;
    private Integer pagesNum;

}
