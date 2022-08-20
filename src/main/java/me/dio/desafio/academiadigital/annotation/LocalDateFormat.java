package me.dio.desafio.academiadigital.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // IMPORTANT
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
public @interface LocalDateFormat {
}
