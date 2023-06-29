package com.example.serve.utils;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PageQuery {
    /**
     * 当前页码
     */
    @ApiModelProperty("当前页数")
    @NotNull(message = "当前页数不能为空！")
    @Min(value = 1, message = "当前页数参数有误")
    private Integer page;
    /**
     * 每页条数
     */
    @ApiModelProperty("每页条数")
    @NotNull(message = "每页条数不能为空！")
    @Range(min = 1, max = 100, message = "每页条数最小1，最大100")
    private Integer size;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
