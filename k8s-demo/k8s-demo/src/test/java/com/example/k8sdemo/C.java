package com.example.k8sdemo;

/**
 * @className: C
 * @description: TODO 类描述
 * @date: 2024/4/29
 **/
class Parent {
    protected void test() {
        System.out.println("父类方法");
        test2(); // 调用test2方法
    }

    private void test2() {
        System.out.println("父类this: " + this);
    }
}

class Son extends Parent {



    public void demonstrate() {
        System.out.println("子类调用父类 ");
        super.test(); // 明确使用super调用父类的test方法
    }

    public static void main(String[] args) {
        Son sonInstance = new Son();
        sonInstance.demonstrate();
    }
}