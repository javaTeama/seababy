package com.example.seababy.annotations;

import io.vertx.core.http.HttpMethod;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface RequestMapping {
    String value() default "";

    HttpMethod[] method() default {};
}
