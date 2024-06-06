package behavior.ChainOfResponsibility.handle;

import behavior.ChainOfResponsibility.message.IStudent;

public abstract class AbstractHandler implements IHandle {
    @Override
    public void handleRequest(IStudent iStudent) {
        //学生对象存在
        if (iStudent != null)
            this.process(iStudent);
    }

    // 处理请求 交给子类具体实现
    public abstract void process(IStudent iStudent);


}
