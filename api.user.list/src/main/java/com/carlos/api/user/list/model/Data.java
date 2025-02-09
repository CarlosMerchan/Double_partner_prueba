package com.carlos.api.user.list.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Data {

    @JsonProperty("total_count")
    private Integer totalCount;
    @JsonProperty("incomplete_results")
    private Boolean incompleteResults;

    private List<Items> items;
}
