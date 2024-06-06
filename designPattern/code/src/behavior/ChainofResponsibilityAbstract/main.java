package behavior.ChainofResponsibilityAbstract;

/**
 * @className: main
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/9/1
 **/
public class main {
    public static void main(String[] args) {
        AHander aHander = new AHander();
        BHander bHander = new BHander();
        aHander.setNextHander(bHander);
        aHander.handle("B");

    }
}
