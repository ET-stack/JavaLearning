package create.FactoryMethod01;

/**
 * @className: FileLoggerFactory
 * @description: TODO 类描述
 * @date: 2023/10/13
 **/
public class FileLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}
