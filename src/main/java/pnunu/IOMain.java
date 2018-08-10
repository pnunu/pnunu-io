package pnunu;

import pnunu.io.InputStream2String;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author: pnunu
 * @Date: Created in 16:34 2018/8/10
 * @Description: 测试类
 */
public class IOMain {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("pnunu.io.InputStream2String");
        Constructor constructor = clazz.getConstructor();
        InputStream2String inputStream2String = (InputStream2String) constructor.newInstance();

        int methodSize = 12;
        for (int i = 1; i <= methodSize; i++) {
            long start = System.currentTimeMillis();
            String num;
            if (i < 10) num = "0" + i;
            else num = "" + i;
            Method method = clazz.getMethod("readInputStream" + num);            //获取 readInputStream01 无参方法
            method.invoke(inputStream2String);
            long end = System.currentTimeMillis();
            System.out.println("readInputStream" + num + ", ms:" + (end - start));
        }


//        Method m1 = clazz.getMethod("papapa", String.class, int.class); //获取有参的方法
//        m1.invoke(inputStream2String, "范冰冰", 20);
    }
}
