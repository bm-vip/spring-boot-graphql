# graphql-spring-boot-example

You'll need [Java 11 or 17](https://www.oracle.com/java/technologies/downloads/).

Clone this repo and execute `mvnw spring-boot:run`. Or inside an IDE, execute the class `com.behrooz.graphql.SpringbootGraphqlApplication`.

To access the database, you can go to [http://localhost:8080/h2-console](http://localhost:8080/h2-console) and enter the following information:
- JDBC URL: jdbc:h2:mem:testdb
- User Name: sa
- Password: password

Or go to [http://localhost:8080/graphiql](http://localhost:8080/graphiql) to start executing queries. For example:
```
query {
  findAllBooks {
    author {
      id
      firstName
      lastName
    }
    id
    name
    pageCount
  }
}
```

Or:
```
mutation {
  newBook(
    title: "Java: The Complete Reference, Tenth Edition"
    isbn: "1259589331"
    pageCount: 10
    authorId: 1
  ) {
    id
    isbn
    pageCount
    title
    author {
      firstName
      id
      lastName
    }
  }
}
```

# Extras

This build demos some UIs hosted at [graphql-java-kickstart](https://github.com/graphql-java-kickstart/graphql-spring-boot).
* Launch with `mvn spring-boot:run`
* Open a browser to view UIs at the following links:
    * [GraphiQL](http://localhost:8080/graphiql)

[//]: # (    * [Altair]&#40;http://localhost:8080/altair&#41;)

[//]: # (    * [Playground]&#40;http://localhost:8080/playground&#41;)

[//]: # (    * [Voyager]&#40;http://localhost:8080/voyager&#41;)