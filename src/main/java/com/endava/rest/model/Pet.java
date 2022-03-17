package com.endava.rest.model;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet {

    protected Long id;

    private Category category;

    @NotNull
    private String name;

    private List<Tag> tags = new ArrayList<>();

    public enum Status {
        AVAILABLE,
        PENDING,
        SOLD
    }
    private final String status;

    public Status setStatus(String status) {
        for (Status e : Status.values()) {
            if (e.equals(status)) {
                return e;
            }
        }
        return null;
    }
}
