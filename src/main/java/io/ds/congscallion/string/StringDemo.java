/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

/**
 *
 *
 * @author wangcong
 * @version $Id: StringDemo.java, v0.1 8/20/19 4:39 PM wangcong Exp $$
 */
public class StringDemo {

    public static void main(String[] args) {
//        test等等运算符比较();

        testEq();
    }


    private static void test等等运算符比较() {
        String name = "Scala";
        String name1 = "Scala";
        String name2 = new String("Scala");
        String name3 = new String("Scala").intern();

        System.out.println(name == name1);
        System.out.println(name == name2);
        System.out.println(name == name3);

    }


    private static void testEq() {
        String name = "Java";
        String name_1 = "Java";
        String name_2 = new String("Java");

        if (name.equals(name_1)) {
            System.out.println("name and name_1 are equal String by equals method");
        }

        if (name.equals(name_2)) {
            System.out.println("name_1 and name_2 are equal String by equals method");
        }
    }

}
