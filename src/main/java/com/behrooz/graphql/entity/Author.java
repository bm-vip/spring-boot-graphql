package com.behrooz.graphql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Author {
    @Id
    @SequenceGenerator(name = "seq_author", sequenceName = "seq_author", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_author")
    private Long id;
    private String firstName;
    private String lastName;
}
