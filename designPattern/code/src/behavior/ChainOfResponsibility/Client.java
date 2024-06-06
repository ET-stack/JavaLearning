package behavior.ChainOfResponsibility;

import behavior.ChainOfResponsibility.handle.IHandle;
import behavior.ChainOfResponsibility.impl.SchoolMasterHandler;
import behavior.ChainOfResponsibility.impl.SquadLeaderHandler;
import behavior.ChainOfResponsibility.impl.TeacherHandler;
import behavior.ChainOfResponsibility.message.IStudent;
import behavior.ChainOfResponsibility.message.Student;

import java.util.Random;

/**
 * 主应用程序
 */
public class Client {
    public static void main(String[] args) {
        IHandle sqmsHandler = new SquadLeaderHandler();
        IHandle techHandler = new TeacherHandler();
        IHandle scmsHandler = new SchoolMasterHandler();
        //创建随机数对象，用来随机产生学生对象
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            //获得随机数
            int radom = random.nextInt(3);
            IStudent student = new Student(radom, "学生" + i + "生病了,需要请假");
            System.out.println("#############开始##############");
            if (0 == student.getState()) {
                sqmsHandler.handleRequest(student);
            } else {
                System.out.println("班长处理不了 下一级继续请求");
                if (1 == student.getState()) {
                    System.out.println("请求上级领导批复");
                    techHandler.handleRequest(student);
                } else {

                    if (student.getState() == 2) {
                        //猜想：这只是三层 要是N层呢，并且使用if的效率低下 有没有更好的办法呢
                        scmsHandler.handleRequest(student);
                    }
                }
            }
            System.out.println("----------结束----------------");
        }
    }
}

/**
 * 答案是外观模式进行封装
 */
