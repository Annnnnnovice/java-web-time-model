package com.inet.timemodel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * 轮播图管理
 * @author HCY
 * @since 2021/1/28 下午12:19
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Carousel {
    /**
     * 主键
     */
    private String id;
    /**
     * 轮播图的名字
     */
    private String name;
    /**
     * 轮播图URL
     */
    private String carouselUrl;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifyTime;
}
