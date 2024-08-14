package com.behrooz.graphql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Book {
    @Id
    @SequenceGenerator(name = "seq_book", sequenceName = "seq_book", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_book")
    private Long id;
    private String name;
    private Integer pageCount;
    @ManyToOne
    private Author author;
}
