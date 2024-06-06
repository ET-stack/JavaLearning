package behavior.ChainOfResponsibility.message;


/**
 * 学生实现类
 */
public class Student implements IStudent {

    //病情状态 -1 为正常
    private int state = -1;
    //请假消息
    private final String message;

    public Student(int state, String message) {
        //初始化基础信息
        this.message = message;
        this.state = state;
    }


    @Override
    public int getState() {
        return this.state;
    }

    @Override
    public String getRequestMessage() {
        return this.message;
    }
}
