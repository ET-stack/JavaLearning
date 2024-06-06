package create.FactoryMethod01;

/**
 * @className: ConsoleLogger
 * @description: TODO 类描述
 * @date: 2023/10/13
 **/
public class ConsoleLogger implements Logger{
    @Override
    public void log(String message) {
        System.out.println("日志记录在控制台："+message);
    }
}
