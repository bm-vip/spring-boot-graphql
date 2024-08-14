package com.behrooz.graphql.controller;

import com.behrooz.graphql.entity.Author;
import com.behrooz.graphql.exception.AuthorNotFoundException;
import com.behrooz.graphql.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthorsController {
    private final AuthorRepository repository;

    @QueryMapping
    public long countAuthors() {
        return repository.count();
    }

    @QueryMapping
    public Author findAuthorById(@Argument long id){
        return repository.findById(id).orElseThrow(()->new AuthorNotFoundException("no such author.id",id));
    }
    @QueryMapping
    public Iterable<Author> findAllAuthors() {
        return repository.findAll();
    }

    @MutationMapping
    public Author newAuthor(@Argument String firstName, @Argument String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        repository.save(author);

        return author;
    }

}
