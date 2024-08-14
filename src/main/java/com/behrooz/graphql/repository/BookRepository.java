package com.behrooz.graphql.repository;

import com.behrooz.graphql.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @EntityGraph(attributePaths = {"author"})
    Optional<Book> findById(Long id);
}
