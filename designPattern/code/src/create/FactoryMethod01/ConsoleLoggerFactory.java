package create.FactoryMethod01;

/**
 * @className: ConsoleFactory
 * @description: TODO 类描述
 * @date: 2023/10/13
 **/
public class ConsoleLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        return new ConsoleLogger();
    }
}
