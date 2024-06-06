package com.thread.demo.ThreadUnsafeExample;

public class ThreadUnsafeExample {
    private int cnt = 0;

    public synchronized  void add() {
        cnt++;
    }

    public int get() {
        return cnt;
    }
}
