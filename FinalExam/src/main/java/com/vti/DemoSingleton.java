package com.vti;



public class DemoSingleton {//Eager singleton
//    public DemoSingleton() {
//        showInfo();
//    }
    private static DemoSingleton instance = new DemoSingleton();

    private DemoSingleton() {
        //showInfo();
    }

    public  static DemoSingleton getInstance() {
        return instance;
    }

    public void showInfo() {
        System.out.println("This is a singleton class");
    }

}
