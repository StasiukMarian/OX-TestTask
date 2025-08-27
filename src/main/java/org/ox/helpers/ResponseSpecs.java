package org.ox.helpers;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecs {
    public static ResponseSpecification responseSpecificationOk200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseSpecificationBadRequest400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }
}
