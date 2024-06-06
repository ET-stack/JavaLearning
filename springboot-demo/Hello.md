### HelloWorld 级别的demo
HelloController 可单步调试查看源代码 
@SpringBootApplication注解其实为
1.@Target({ElementType.TYPE})
2.@Retention(RetentionPolicy.RUNTIME)
3.@Documented
4.@Inherited
5.@SpringBootConfiguration
6.@EnableAutoConfiguration  
7.@ComponentScan的注解集合  
所以可以看出SpringBoot就是集合各种框架的启动器

@Controller：修饰class，用来创建处理http请求的对象
@RestController：Spring4之后加入的注解，原来在@Controller中返回json需要@ResponseBody来配合，如果直接用@RestController替代@Controller就不需要再配置@ResponseBody，默认返回json格式。
@RequestMapping：配置url映射
http://blog.didispace.com/content/images/posts/springbootrestfulapi-1.png