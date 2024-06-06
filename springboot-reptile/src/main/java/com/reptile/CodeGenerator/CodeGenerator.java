package com.reptile.CodeGenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (ipt != null && !ipt.equals("")) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 创建 generator 对象（生成的对象）
        AutoGenerator autoGenerator = new AutoGenerator();

        // 数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/basecurrency?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=GMT%2B8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        autoGenerator.setDataSource(dataSourceConfig);

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");   // 设置生成的目录
        globalConfig.setOpen(false);  // 生成成功后不会自动打开这个文件夹
        globalConfig.setAuthor("xiaofei");  // 生成的作者
        globalConfig.setServiceName("%sService");  // Service接口去掉前面的I
        autoGenerator.setGlobalConfig(globalConfig);

        // 包信息
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.example.MBS");  // 设置父包
        packageConfig.setModuleName("generator");
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("serviceImpl");
        packageConfig.setMapper("com/reptile/mapper");
        packageConfig.setEntity("entity");
        autoGenerator.setPackageInfo(packageConfig);

        // 配置策略
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("sys_user");  // 要生成的表名
        strategyConfig.setEntityLombokModel(true);  // 自动添加 Lombok 注解
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);  // 数据库表映射到实体的命名策略，下划线转驼峰命名
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);  // 数据库表字段映射到实体的命名策略，下划线转驼峰命名
        autoGenerator.setStrategy(strategyConfig);

        // 执行
        autoGenerator.execute();
    }


}
