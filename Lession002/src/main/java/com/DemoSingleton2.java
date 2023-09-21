package com;

public class DemoSingleton2 {

    private static DemoSingleton instance = new DemoSingleton();

    private void DemoSingleton() {
        //showInfo();
    }

    public  static DemoSingleton getInstance() {
        return instance;
    }

    public void showInfo() {
        System.out.println("This is a singleton class");
    }

}
