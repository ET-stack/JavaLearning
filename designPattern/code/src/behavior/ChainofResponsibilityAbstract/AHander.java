package behavior.ChainofResponsibilityAbstract;

/**
 * @className: AHander
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/9/1
 **/
public class AHander extends AbstractHander {

    private AbstractHander abstractHander;

    /**
     * A处理器的业务逻辑
     * @param operationStr
     */
    @Override
    public void handle(String operationStr) {
        if ("A".equals(operationStr)){

            System.out.println("A自己能解决");
            return;
        }else {
            System.out.println("A自己不能解决抛给下一层");
            if (abstractHander != null){
                abstractHander.handle(operationStr);
            }


        }
    }


    @Override
    public void setNextHander(AbstractHander nextHander) {
        this.abstractHander = nextHander;
    }
}
