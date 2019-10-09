package com.bradypod.base.domain.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *
 * @author https://github.com/JumperYu
 * @version 2019/09/29
 */
@Data
@Accessors(chain = true)
public class PageRequest implements Serializable {

    private Integer offset;
    private Integer limit;
    private String search;
    private String sort;
    private String orderBy;

    public Integer getOffset() {
        return this.offset < 0 ? 0 : this.offset;
    }

    public Integer getLimit() {
        return this.limit <= 0 ? 10 : this.limit;
    }
}
