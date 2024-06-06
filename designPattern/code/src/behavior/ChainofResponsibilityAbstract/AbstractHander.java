package behavior.ChainofResponsibilityAbstract;

import behavior.ChainOfResponsibility.handle.AbstractHandler;

/**
 * @className: AbstractHander
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/8/31
 **/
public abstract class AbstractHander  {
    protected AbstractHandler nextHander;

    public abstract void handle(String operationStr);

    public abstract void setNextHander(AbstractHander nextHander);


}
