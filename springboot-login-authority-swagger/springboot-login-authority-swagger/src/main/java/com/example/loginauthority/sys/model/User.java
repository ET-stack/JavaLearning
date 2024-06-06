package com.example.loginauthority.sys.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("系统管理-用户基础信息表")
@TableName("t_sys_user") //指定表名 也可以使用table-prefix
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Integer id;

    /**
     * 账号
     */
    @ApiModelProperty("账号")
    private String username;

    /**
     * 登录密码
     */
    @ApiModelProperty("登录密码")
    private String password;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickName;

    /**
     * 性别 0:男 1:女
     */
    @ApiModelProperty("性别 0:男 1:女")
    private String sex;

    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private String flag;

    /**
     * 盐值
     */
    @ApiModelProperty("盐值")
    private String salt;

    /**
     * token
     */
    @ApiModelProperty("token")
    private String token;

    /**
     * qq 第三方登录oppen_id唯一标识
     */
    @ApiModelProperty("qq 第三方登录oppen_id唯一标识")
    private String qqOppenId;

    /**
     * 明文密码
     */
    @ApiModelProperty("明文密码")
    private String pwd;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date gmtModified;

    /**
     * 1存在0删除
     */
    @ApiModelProperty("1存在0删除")
    private Integer delFlag;

    public User() {}
}
