package behavior.ChainOfResponsibility.impl;

import behavior.ChainOfResponsibility.handle.AbstractHandler;
import behavior.ChainOfResponsibility.message.IStudent;

public class SchoolMasterHandler extends AbstractHandler {
    @Override
    public void process(IStudent iStudent) {
        System.out.println("校长解决问题" + iStudent.getRequestMessage());
    }
}
