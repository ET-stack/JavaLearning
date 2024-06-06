package create.FactoryMethod01;

/**
 * @className: FileLogger
 * @description: TODO 类描述
 * @date: 2023/10/13
 **/
public class FileLogger implements Logger{
    @Override
    public void log(String message) {
        System.out.println("日志记录到文件："+message);
    }
}
