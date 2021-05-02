package com.inet.timemodel.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 自定义分页对象
 *
 * @author HCY
 * @since 2021/1/3 上午9:53
*/
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Pages<T> {

    /**
     * 内容
     */
    private List<T> information;

    /**
     * 当前页的条目数
     */
    private Integer pageSize;

    /**
     * 当前页数
     */
    private Integer pageCurrent;

    /**
     * 总条目数
     */
    private Integer pageTotal;

    /**
     * 总页数
     */
    private Integer pageCount;

    public Pages(List<T> information, Integer pageSize, Integer pageCurrent, Integer pageTotal) {
        this.information = information;
        this.pageSize = pageSize;
        this.pageCurrent = pageCurrent;
        this.pageTotal = pageTotal;
        this.pageCount = ( pageTotal % pageSize ) == 0 ? (pageTotal / pageSize) : (pageTotal / pageSize) + 1 ;
    }
}
