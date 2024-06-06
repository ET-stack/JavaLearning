package behavior.ChainOfResponsibility.impl;

import behavior.ChainOfResponsibility.handle.AbstractHandler;
import behavior.ChainOfResponsibility.message.IStudent;

public class SquadLeaderHandler extends AbstractHandler {
    @Override
    public void process(IStudent iStudent) {
        System.out.println("班长 解决问题" + iStudent.getRequestMessage());
    }
}
