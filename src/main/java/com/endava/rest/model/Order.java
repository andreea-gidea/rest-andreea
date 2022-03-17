package com.endava.rest.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class Order {

    protected Long id;

    private Pet pet;

    private Integer quantity;

    @NotNull
    private LocalDateTime shipDate;

    private enum status {
        PLACED,
        APPROVED,
        DELIVERED
    }

    @DefaultValue (false)
    private Boolean delivered;

}
