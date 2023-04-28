package com.example.serve.utils;

import lombok.Data;

import java.util.List;

@Data
public class PageList<T> {

    private List<T> content;

    private Integer total;

}
