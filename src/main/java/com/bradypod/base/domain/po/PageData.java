package com.bradypod.base.domain.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class PageData<T> implements Serializable {

    private int total;
    private List<T> rows;
}
