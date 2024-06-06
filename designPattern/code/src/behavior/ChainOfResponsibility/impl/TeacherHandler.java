package behavior.ChainOfResponsibility.impl;

import behavior.ChainOfResponsibility.handle.AbstractHandler;
import behavior.ChainOfResponsibility.message.IStudent;

public class TeacherHandler extends AbstractHandler {
    @Override
    public void process(IStudent iStudent) {
        System.out.println("老师解决问题" + iStudent.getRequestMessage());
    }
}
