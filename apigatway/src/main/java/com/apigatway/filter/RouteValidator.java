package com.apigatway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> openApiEndpoints = List.of(
    		"/store/h1",
    		"/store/validate",
    		"/store/login",
    		"/store/healthcareprovider",
    		"/store/patient",
    		"/store/patientshistory",
    		"/store/get/patients/{id}",
    		"/store/get/patientshistory/{id}"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}