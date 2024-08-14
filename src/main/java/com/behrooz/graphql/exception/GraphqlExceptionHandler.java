package com.behrooz.graphql.exception;

import graphql.GraphQLException;
import graphql.GraphqlErrorException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class GraphqlExceptionHandler {
//    @ExceptionHandler(GraphQLException.class)
//    public GraphqlErrorException handler(GraphQLException e, HttpServletRequest request){
//        return new GraphqlErrorException(new GraphqlErrorException.Builder());
//    }
}
