/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.array.chat00;

/**
 * @author wangcong
 * @version $Id: PrivateInnterClassDemo.java, v0.1 7/1/19 11:39 AM wangcong Exp $$
 */
public class PrivateInnterClassDemo {

    private static final int MAX_SIZE = 10;
    private static int AGE = 12;
    private String name;

    public static void main(String[] args) {

        PrivateInnterClassDemo privateInnterClassDemo = new PrivateInnterClassDemo();
        privateInnterClassDemo.name = "张三丰";

        System.out.println(privateInnterClassDemo.name);
        System.out.println(privateInnterClassDemo.AGE);

        System.out.println(privateInnterClassDemo.getStd().getName());
        System.out.println(privateInnterClassDemo.getStd().getAge());
        System.out.println(privateInnterClassDemo.getStd().checkAge());


    }

    private Student getStd() {
        return new Student();
    }

    private class Student {

        private String name;
        private int age;

        public Student() {
            this.name = PrivateInnterClassDemo.this.name;
            this.age = AGE;
        }

        private boolean checkAge() {
            return this.age >= MAX_SIZE;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
