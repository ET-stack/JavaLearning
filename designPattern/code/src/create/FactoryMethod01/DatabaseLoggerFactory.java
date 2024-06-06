package create.FactoryMethod01;

/**
 * @className: DatabaseLoggerFactory
 * @description: TODO 类描述
 * @date: 2023/10/13
 **/
public class DatabaseLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}
