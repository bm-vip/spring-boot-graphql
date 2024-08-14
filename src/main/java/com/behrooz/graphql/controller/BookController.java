package com.behrooz.graphql.controller;

import com.behrooz.graphql.entity.Author;
import com.behrooz.graphql.entity.Book;
import com.behrooz.graphql.exception.NotFoundException;
import com.behrooz.graphql.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookRepository repository;
    @QueryMapping
    public Book findBookById(@Argument long id){
        return repository.findById(id).orElseThrow((NotFoundException::new));
    }
    @QueryMapping
    public Iterable<Book> findAllBooks() {
        return repository.findAll();
    }
    @SchemaMapping
    public Author author(Book book) {
        return book.getAuthor();
    }
}
