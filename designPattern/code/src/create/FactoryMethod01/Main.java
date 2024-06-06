package create.FactoryMethod01;

/**
 * @className: Main
 * @description: TODO 类描述
 * @date: 2023/10/13
 **/
public class Main {
    public static void main(String[] args) {
        // 创建文件日志记录器
        LoggerFactory fileLoggerFactory = new FileLoggerFactory();
        Logger fileLogger = fileLoggerFactory.createLogger();
        fileLogger.log("这是一条文件日志");

        // 创建数据库日志记录器
        LoggerFactory databaseLoggerFactory = new DatabaseLoggerFactory();
        Logger databaseLogger = databaseLoggerFactory.createLogger();
        databaseLogger.log("这是一条数据库日志");

        // 创建控制台日志记录器
        LoggerFactory consoleLoggerFactory = new ConsoleLoggerFactory();
        Logger consoleLogger = consoleLoggerFactory.createLogger();
        consoleLogger.log("这是一条控制台日志");
    }

}
