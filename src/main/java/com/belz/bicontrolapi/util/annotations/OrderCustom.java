package com.belz.bicontrolapi.util.annotations;

import org.springframework.data.domain.Sort;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface OrderCustom {
    Sort.Direction sortDirection() default Sort.Direction.ASC;
}
