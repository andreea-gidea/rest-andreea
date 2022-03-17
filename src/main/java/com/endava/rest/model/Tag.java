package com.endava.rest.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Tag {

    protected Long id;

    @NotNull
    private String name;
}
