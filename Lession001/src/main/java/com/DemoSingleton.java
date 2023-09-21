package com;

import com.repository.ArticleRepository;

public class DemoSingleton {
    // public DemoSingleton(){
    //   showInfor();
    //}

    private static DemoSingleton instance = new DemoSingleton();

    DemoSingleton() {
        //showInfo();
    }

    public  static DemoSingleton getInstance() {
        return instance;
    }

    public void showInfo() {
        System.out.println("This is a singleton class");
    }

//        DemoSingleton demoSingleton1 = new DemoSingleton();
//        DemoSingleton demoSingleton2 = new DemoSingleton();
    // A.showInfo();

//        A a = new A();
//
//        a.showInfo();
    /* Demo singleton */
//        DemoSingleton demoSingleton = DemoSingleton.getInstance();
//        DemoSingleton.getInstance();

    ArticleRepository articleRepository = new ArticleRepository();

}
