///**
// * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
// */
//package io.ds.congscallion.array.chat01;
//
//import org.assertj.core.api.Assertions;
//import org.junit.Test;
//
///**
// * @author wangcong
// * @version $Id: ArrayDefineTest.java, v0.1 5/28/19 8:48 PM wangcong Exp $$
// */
//public class ArrayDefineTest {
//
//    @Test
//    public void printSupperObject() {
//        int intArray[] = new int[3];
//        byte byteArray[] = new byte[3];
//        short shortArray[] = new short[3];
//
//        String strArray[] = new String[3];
//
//        Student studentArray[] = new Student[3];
//
//        System.out.println(intArray.getClass());
//        System.out.println(intArray.getClass().getSuperclass());
//        System.out.println(byteArray.getClass());
//        System.out.println(shortArray.getClass());
//        System.out.println(strArray.getClass());
//        System.out.println(studentArray.getClass());
//    }
//
//
//    @Test
//    public void oneDimensionalRefTypeClone() {
//
//        Student studentArray[] = new Student[3];
//        studentArray[0] = new Student();
//        studentArray[1] = new Student();
//        studentArray[2] = new Student();
//
//        Student cloneArray[] = studentArray.clone();
//
//        Assertions.assertThat(studentArray == cloneArray).isFalse();
//        Assertions.assertThat(studentArray).isEqualTo(cloneArray);
//        Assertions.assertThat(studentArray[0]).isEqualTo(cloneArray[0]);
//        Assertions.assertThat(studentArray[1]).isEqualTo(cloneArray[1]);
//        Assertions.assertThat(studentArray[2]).isEqualTo(cloneArray[2]);
//
//    }
//
//    @Test
//    public void oneDimensionalintTypeClone() {
//
//        int intArray[] = {1, 2, 3};
//
//        int cloneArray[] = intArray.clone();
//        cloneArray[1] = 3;
//
//        Assertions.assertThat(intArray == cloneArray).isFalse();
//        Assertions.assertThat(intArray).isNotEqualTo(cloneArray);
//        Assertions.assertThat(intArray[1]).isEqualTo(2);
//        Assertions.assertThat(cloneArray[1]).isEqualTo(3);
//
//    }
//
//    @Test
//    public void doubleEqual() {
//        Assertions.assertThat(10.00D).isEqualTo(10.00D);
//        Assertions.assertThat(10.00D == 10.00D).isTrue();
//        Assertions.assertThat(12.321d == 12.231d).isFalse();
////        Assertions.assertThat(Double.doubleToLongBits(12.321d) == Double.doubleToLongBits(12.231d)).isTrue();
//        Assertions.assertThat(12.321d).isEqualTo(12.321d);
//
//        System.out.println(Double.doubleToLongBits(12.321d));
//        System.out.println(Double.doubleToLongBits(12.321d));
//        System.out.println(Double.doubleToLongBits(12.321d));
//        System.out.println(Double.doubleToLongBits(12.321d));
//
//        long l1 = Double.doubleToLongBits(12.321d);
//        long l2 = Double.doubleToLongBits(12.231d);
//
//        System.out.println(l1);
//        System.out.println(l2);
//        System.out.println(12.321192031d == 12.321192031d);
//
//    }
//
//
//}
//
//class Student {
//
//
//}