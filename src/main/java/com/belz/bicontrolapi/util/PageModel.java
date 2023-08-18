package com.belz.bicontrolapi.util;

import com.belz.bicontrolapi.util.annotations.OrderCustom;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

@Getter
@Setter
public class PageModel {
    private int pageNumber = 0;
    private int pageSize= 10;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortBy;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Class<?> entityClass;

    public PageModel(){}
    public PageModel(Class<?> entityClass) {
        this.entityClass = entityClass;
        init();
    }

    public void setEntityClass(Class<?> entityClass) {
        this.entityClass = entityClass;
        if(this.entityClass!=null)
            init();
    }

    public PageModel(int pageNumber, int pageSize, String sortBy) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sortBy = sortBy;
    }

    public void init() {
        if(entityClass!=null) {
            Optional<Field> firstId = Arrays.stream(entityClass.getDeclaredFields())
                    .filter(x -> x.getDeclaredAnnotation(OrderCustom.class) != null)
                    .findFirst();
            if (sortBy == null || sortBy.trim().length() == 0) {
                if (firstId.isPresent()) {
                    firstId.ifPresent(column -> sortBy = column.getName());
                } else {
                    firstId = Arrays.stream(entityClass.getDeclaredFields())
                            .filter(x -> x.getDeclaredAnnotation(Id.class) != null)
                            .findFirst();
                    firstId.ifPresent(column -> sortBy = column.getName());
                }
            }
        }
    }
}