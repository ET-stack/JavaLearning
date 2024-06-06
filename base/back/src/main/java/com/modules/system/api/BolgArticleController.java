package com.modules.system.api;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog/article")
@Api(description = "博客管理 -文章表接口")
public class BolgArticleController {

}
