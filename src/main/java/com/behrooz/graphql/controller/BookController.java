package com.behrooz.graphql.controller;

import com.behrooz.graphql.entity.Author;
import com.behrooz.graphql.entity.Book;
import com.behrooz.graphql.exception.BookNotFoundException;
import com.behrooz.graphql.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookRepository repository;

    @QueryMapping
    public long countBooks() {
        return repository.count();
    }

    @QueryMapping
    public Book findBookById(@Argument long id){
        return repository.findById(id).orElseThrow(()->new BookNotFoundException("no such book.id",id));
    }
    @QueryMapping
    public Iterable<Book> findAllBooks() {
        return repository.findAll();
    }
    @SchemaMapping
    public Author author(Book book) {
        return book.getAuthor();
    }

    @MutationMapping
    public Book newBook(@Argument String title, @Argument String isbn, @Argument Integer pageCount, @Argument Long authorId) {
        Book book = new Book();
        var author = new Author();
        author.setId(authorId);
        book.setAuthor(author);
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        repository.save(book);

        return book;
    }
    @MutationMapping
    public boolean deleteBook(@Argument Long id) {
        repository.deleteById(id);
        return true;
    }
    @MutationMapping
    public Book updateBookPageCount(@Argument Integer pageCount, @Argument Long id) {
        Optional<Book> opt = repository.findById(id);
        if (opt.isPresent()) {
            Book book = opt.get();
            book.setPageCount(pageCount);
            repository.save(book);
            return book;
        }
        throw new BookNotFoundException("no such book.id", id);
    }
}
