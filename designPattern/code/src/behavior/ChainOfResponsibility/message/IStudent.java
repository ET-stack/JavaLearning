package behavior.ChainOfResponsibility.message;

public interface IStudent {

    /**
     * 获得学生病情状态
     * 0:班长能解决
     * 1:班长解决不了 老师解决
     * 2:老师解决不了 校长解决
     */
    public int getState();

    /**
     * 获得学生请假信息
     */
    public String getRequestMessage();
}
