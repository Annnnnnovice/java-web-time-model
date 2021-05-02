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
 * 登陆的用户
 * @author HCY
 * @since 2021/1/25 下午7:46
*/
public class User {
    /**
     * 序号
     */
    private String id;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String cipher;

    /**
     * 用户名
     */
    private String name;

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
