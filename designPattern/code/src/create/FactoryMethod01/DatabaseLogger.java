package create.FactoryMethod01;

/**
 * @className: DatabaseLogger
 * @description: TODO 类描述
 * @date: 2023/10/13
 **/
public class DatabaseLogger implements Logger{
    @Override
    public void log(String message) {
        System.out.println("日志记录到数据里："+message);
    }
}
