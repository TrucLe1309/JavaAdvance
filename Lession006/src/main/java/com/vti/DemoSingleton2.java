package com.vti;



public class DemoSingleton2 {// Lazy singleton
//    public DemoSingleton() {
//        showInfo();
//    }
    private static DemoSingleton2 instance;

    private DemoSingleton2() {
        //showInfo();
    }

    public  static DemoSingleton2 getInstance() {
        if (instance == null) {
            instance = new DemoSingleton2();
        }
        return instance;
    }

    public void showInfo() {
        System.out.println("This is a singleton class");
    }

}
