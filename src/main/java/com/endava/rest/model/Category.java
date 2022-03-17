package com.endava.rest.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Category {

    protected Long id;

    @NotNull
    @Size(min = 4, max = 50)
    private String name;

}
