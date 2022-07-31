package org.example;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.lang.reflect.Method;

public class MyListener implements ISuiteListener {

    @Override
    public void onStart(ISuite iSuite) {
        Method[] methods = Main.class.getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Main.TestMethodInfo.class)) {
                Main.TestMethodInfo ta = m.getAnnotation(Main.TestMethodInfo.class);
                System.out.println("Start tests");
                System.out.println(ta.priority());
                System.out.println(ta.author());
                System.out.println(ta.lastModified());

            }
        }

    }

    @Override
    public void onFinish(ISuite iSuite) {
        Method[] methods = Main.class.getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Main.TestMethodInfo.class)) {
                Main.TestMethodInfo ta = m.getAnnotation(Main.TestMethodInfo.class);
                System.out.println("Finish Tests");
                System.out.println(ta.priority());
                System.out.println(ta.author());
                System.out.println(ta.lastModified());            }
        }
    }
}
