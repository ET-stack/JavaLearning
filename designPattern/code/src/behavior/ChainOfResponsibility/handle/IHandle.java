package behavior.ChainOfResponsibility.handle;

import behavior.ChainOfResponsibility.message.IStudent;

/**
 * 抽象处理着接口
 */
public interface IHandle {
    //处理请求
    public void handleRequest(IStudent iStudent);
}
