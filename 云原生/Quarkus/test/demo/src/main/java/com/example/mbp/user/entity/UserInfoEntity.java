package com.example.mbp.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息 Entity
 *
 * @author abing
 * @date 2022/5/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
@TableName("t_user_info")
public class UserInfoEntity implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    public Long id;

    /**
     * 邮箱
     */
    public String email;

    /**
     * 密码
     */
    public String password;

    /**
     * 真实姓名
     */
    @TableField("actual_name")
    public String actualName;

    /**
     * 年龄
     */
    public Integer age;

    /**
     * 手机号
     */
    public String phone;

    /**
     * 是否删除：0.未删除，1.已删除
     */
    @TableField("is_del")
    public Integer isDel;

    /**
     * 创建时间
     */
    @TableField("create_time")
    public Date createTime;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

