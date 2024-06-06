### Controller和RestController的区别
习惯性用Controller了   在SpringBoot里面如果要放回视图的话应该用RestController 
如果用Controller则会报错
@RestController注解相当于@ResponseBody＋@Controller合在一起的作用。
