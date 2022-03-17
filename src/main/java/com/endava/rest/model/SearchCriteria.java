package com.endava.rest.model;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchCriteria {

    private String fieldName;

    @NotEmpty
    private String fieldValue;

    private Boolean exactMatch;

    private String noResults;

}
