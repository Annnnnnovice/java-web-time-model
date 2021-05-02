package com.inet.timemodel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
/**
 * 时代楷模的基本信息
 *
 * @author HCY
 * @since 2021/1/25 下午7:46
 */
public class RoleModel {
    /**
     * 主键
     */
    private String id;
    /**
     * 名字
     */
    private String name;
    /**
     * 照片
     */
    private String photo;
    /**
     * 授予时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date awardedTime;
    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;
    /**
     * 荣誉称号
     */
    private String titleHonor;
    /**
     * 百度百科(介绍)
     */
    private String produceUrl;
    /**
     * 地址
     */
    private String address;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date modifyTime;
}
