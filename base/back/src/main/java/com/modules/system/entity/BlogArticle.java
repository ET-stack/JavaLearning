package com.modules.system.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.modules.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "文章管理 - 文章表")
@TableName("blog_article")
public class BlogArticle extends BaseEntity<BlogArticle> {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    @TableId(value="id", type= IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "文章类型ID")
    @TableField("article_type_id")
    private Integer articleTypeId;

    @ApiModelProperty(value = "文章标题")
    @TableField("article_title")
    private String articleTitle;

    @ApiModelProperty(value = "文章内容")
    @TableField("article_content")
    private String articleContent;

    @ApiModelProperty(value = "文章发布时间")
    @TableField("article_sdTime")
    private String articleSdTime;

    @ApiModelProperty(value = "文章信息")
    @TableField("article_info")
    private String articleInfo;

    @ApiModelProperty(value = "文章点击数量")
    @TableField("article_count")
    private String articleCount;

    @ApiModelProperty(value = "0原创1转载")
    @TableField("article_from")
    private String articleFrom;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
