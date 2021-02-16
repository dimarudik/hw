package com.example.hw2.model;

import javax.validation.constraints.NotNull;

public class BookIdToRemove {

    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
